package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Department;

public interface DepartmentRepository
    extends JpaRepository<Department, String> {

    @Query("SELECT d FROM Department d WHERE d.faculty.id = ?1")
    List<Department> findAllByFacultyId(String facultyId);
}
