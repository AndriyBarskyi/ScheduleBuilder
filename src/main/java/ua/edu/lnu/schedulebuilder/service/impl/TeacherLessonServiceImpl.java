package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonSaveDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.LessonMapper;
import ua.edu.lnu.schedulebuilder.mapper.TeacherLessonMapper;
import ua.edu.lnu.schedulebuilder.mapper.TeacherMapper;
import ua.edu.lnu.schedulebuilder.model.TeacherLesson;
import ua.edu.lnu.schedulebuilder.repository.LessonRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherLessonRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherRepository;
import ua.edu.lnu.schedulebuilder.service.TeacherLessonService;

import static ua.edu.lnu.schedulebuilder.service.impl.LessonServiceImpl.LESSON_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.TeacherServiceImpl.TEACHER_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class TeacherLessonServiceImpl implements TeacherLessonService {

    static final String TEACHER_LESSON_NOT_FOUND_BY_ID =
        "TeacherLesson not found by id: ";
    private final TeacherLessonRepository teacherLessonRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final LessonMapper lessonMapper;
    private final LessonRepository lessonRepository;
    private final TeacherLessonMapper teacherLessonMapper;

    @Override
    public TeacherLessonDTO getTeacherLessonById(String id) {
        checkThatTeacherLessonExists(id);
        return teacherLessonMapper.entityToDto(
            teacherLessonRepository.getReferenceById(id));
    }

    @Override
    public void deleteTeacherLesson(String id) {
        checkThatTeacherLessonExists(id);
        teacherLessonRepository.deleteById(id);
    }

    @Override
    public TeacherLessonSaveDTO updateTeacherLesson(
        TeacherLessonSaveDTO newTeacherLesson, String id) {
        checkThatTeacherLessonExists(id);
        checkThatTeacherExists(newTeacherLesson.getTeacherId());
        checkThatLessonExists(
            newTeacherLesson.getLessonId());
        return teacherLessonRepository.findById(id)
            .map(teacherLesson -> {
                teacherLessonMapper.updateTeacherLesson(
                    teacherLesson, newTeacherLesson);
                return teacherLessonMapper.entityToSaveDto(
                    teacherLessonRepository
                        .save(teacherLesson));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeacherLessonSaveDTO addNewTeacherLesson(
        TeacherLessonSaveDTO newTeacherLesson) {
        checkThatTeacherExists(newTeacherLesson.getTeacherId());
        checkThatLessonExists(newTeacherLesson.getLessonId());
        return teacherLessonMapper.entityToSaveDto(
            teacherLessonRepository.save(
                teacherLessonMapper.saveDtoToEntity(newTeacherLesson)
            )
        );
    }

    @Override public List<TeacherLessonDTO> getAllTeacherLessons() {
        return this.entitiesToDtos(
            teacherLessonRepository.findAll());
    }

    public List<TeacherLessonDTO> entitiesToDtos(
        List<TeacherLesson> all) {
        if (all == null) {
            return null;
        }

        List<TeacherLessonDTO> list =
            new ArrayList<>(all.size());
        for (TeacherLesson teacherLesson : all) {
            TeacherLessonDTO teacherLessonDTO =
                teacherLessonMapper.entityToDto(teacherLesson);
            teacherLessonDTO.setTeacherDTO(
                teacherMapper.entityToDto(teacherLesson.getTeacher()));
            teacherLessonDTO.setLessonDTO(lessonMapper.entityToDto(
                teacherLesson.getLesson()));
            list.add(teacherLessonDTO);
        }

        return list;
    }

    private void checkThatTeacherLessonExists(String id) {
        if (!teacherLessonRepository.existsById(id)) {
            throw new EntityNotExistsException(
                TEACHER_LESSON_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatLessonExists(String id) {
        if (!lessonRepository.existsById(id)) {
            throw new EntityNotExistsException(LESSON_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatTeacherExists(String id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHER_NOT_FOUND_BY_ID + id);
        }
    }
}
