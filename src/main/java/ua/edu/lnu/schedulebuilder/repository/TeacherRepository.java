package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {
}
