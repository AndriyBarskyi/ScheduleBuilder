package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {
}
