package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.TeacherLessonDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonSaveDTO;

public interface TeacherLessonService {

    TeacherLessonDTO getTeacherLessonById(String id);

    void deleteTeacherLesson(String id);

    TeacherLessonSaveDTO updateTeacherLesson(
        TeacherLessonSaveDTO newTeacherLesson,
        String id);

    TeacherLessonSaveDTO addNewTeacherLesson(
        TeacherLessonSaveDTO newTeacherLesson);

    List<TeacherLessonDTO> getAllTeacherLessons();
}
