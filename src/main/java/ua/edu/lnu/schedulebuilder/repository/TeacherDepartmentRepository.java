package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Teacher;
import ua.edu.lnu.schedulebuilder.model.TeacherDepartment;

public interface TeacherDepartmentRepository extends JpaRepository<TeacherDepartment, String> {
}
