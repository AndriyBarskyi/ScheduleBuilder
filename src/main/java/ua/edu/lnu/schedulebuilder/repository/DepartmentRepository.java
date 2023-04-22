package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Department;
import ua.edu.lnu.schedulebuilder.model.Teacher;

public interface DepartmentRepository extends JpaRepository<Department, String> {
}
