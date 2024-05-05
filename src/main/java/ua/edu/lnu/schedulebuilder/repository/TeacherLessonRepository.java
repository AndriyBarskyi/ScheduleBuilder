package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.TeacherLesson;

public interface TeacherLessonRepository
    extends JpaRepository<TeacherLesson, String> {
}
