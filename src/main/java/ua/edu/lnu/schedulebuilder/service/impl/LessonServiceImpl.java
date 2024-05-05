package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.LessonDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonSaveDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.LessonMapper;
import ua.edu.lnu.schedulebuilder.repository.LessonRepository;
import ua.edu.lnu.schedulebuilder.service.LessonService;
import ua.edu.lnu.schedulebuilder.service.TeacherLessonService;

@Service
public class LessonServiceImpl implements LessonService {

    static final String LESSON_NOT_FOUND_BY_ID = "Lesson not found by id: ";
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final TeacherLessonService teacherLessonService;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository,
        LessonMapper lessonMapper, TeacherLessonService teacherLessonService) {
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
        this.teacherLessonService = teacherLessonService;
    }

    @Override
    public LessonDTO getLessonById(String id) {
        checkThatLessonExists(id);
        return lessonMapper.entityToDto(
            lessonRepository.getReferenceById(id));
    }

    @Override
    public void deleteLesson(String id) {
        checkThatLessonExists(id);
        lessonRepository.deleteById(id);
    }

    @Override
    public LessonDTO updateLesson(LessonDTO newLesson, String id) {
        checkThatLessonExists(id);
        return lessonRepository.findById(id)
            .map(lesson -> {
                lessonMapper.updateLesson(lesson, newLesson);
                return lessonMapper.entityToDto(lessonRepository
                    .save(lesson));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public LessonDTO addNewLesson(LessonDTO newLesson, String teacherId) {
        validateLesson(newLesson, teacherId);
        TeacherLessonSaveDTO teacherLesson = new TeacherLessonSaveDTO();
        teacherLesson.setLessonId(newLesson.getId());
        teacherLesson.setTeacherId(teacherId);
        teacherLessonService.addNewTeacherLesson(teacherLesson);
        return lessonMapper.entityToDto(
            lessonRepository.save(
                lessonMapper.dtoToEntity(newLesson)
            )
        );
    }

    @Override
    public List<LessonDTO> getAllLessonsByGroupId(String lessonId) {
        return lessonMapper.entitiesToDtos(
            lessonRepository.findAllByGroupId(lessonId));
    }

    @Override public List<LessonDTO> getAllLessons() {
        return lessonMapper.entitiesToDtos(lessonRepository.findAll());
    }

    @Override
    public List<LessonDTO> getAllLessonsByGroupIdAndScheduleId(String lessonId,
        String scheduleId) {
        return lessonMapper.entitiesToDtos(
            lessonRepository.findAllByGroupIdAndScheduleId(lessonId,
                scheduleId));
    }

    private void checkThatLessonExists(String id) {
        if (!lessonRepository.existsById(id)) {
            throw new EntityNotExistsException(LESSON_NOT_FOUND_BY_ID + id);
        }
    }

    private void validateLesson(LessonDTO lesson, String teacherId) {
        if (lesson.getLessonNumber() < 1 || lesson.getLessonNumber() > 8) {
            throw new IllegalArgumentException(
                "Lesson number must be between 1 and 8");
        } else if (lessonRepository.teacherHasLessonAtThisTime(teacherId,
            lesson.getLessonNumber(), lesson.getDayOfWeek())) {
            throw new IllegalArgumentException(
                "Teacher already has a lesson at this time");
        } else if (lessonRepository.teacherHasLessonAtThisTime(teacherId,
            lesson.getLessonNumber(), lesson.getDayOfWeek(),
            lesson.isDenominator())) {
            throw new IllegalArgumentException(
                "Teacher already has a lesson at this time in this denominator");
        } else if (lessonRepository.existsByDayOfWeekAndClassroomId(
            lesson.getDayOfWeek(), lesson.getClassroomId(),
            lesson.getLessonNumber())) {
            throw new IllegalArgumentException(
                "Classroom already has a lesson at this time");
        } else if (lessonRepository.existsByDayOfWeekGroupIdAndLessonNumber(
            lesson.getDayOfWeek(), lesson.getGroupId(),
            lesson.getLessonNumber())) {
            throw new IllegalArgumentException(
                "Group already has a lesson at this time");
        }
    }
}

