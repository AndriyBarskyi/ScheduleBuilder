package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Faculty;
import ua.edu.lnu.schedulebuilder.model.Teacher;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
