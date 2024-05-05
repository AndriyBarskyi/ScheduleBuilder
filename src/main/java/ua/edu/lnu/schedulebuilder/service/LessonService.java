package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.LessonDTO;

public interface LessonService {

    LessonDTO getLessonById(String id);

    void deleteLesson(String id);

    LessonDTO updateLesson(LessonDTO newLesson,
        String id);

    LessonDTO addNewLesson(LessonDTO newLesson, String teacherId);

    List<LessonDTO> getAllLessonsByGroupId(String groupId);

    List<LessonDTO> getAllLessons();

    List<LessonDTO> getAllLessonsByGroupIdAndScheduleId(String groupId,
        String scheduleId);
}
