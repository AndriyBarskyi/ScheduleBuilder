package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, String> {
}
