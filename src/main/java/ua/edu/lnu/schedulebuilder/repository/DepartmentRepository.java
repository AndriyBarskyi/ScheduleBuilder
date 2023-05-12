package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Department;

public interface DepartmentRepository
    extends JpaRepository<Department, String> {
}
