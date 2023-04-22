package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Classroom;
import ua.edu.lnu.schedulebuilder.model.Teacher;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {
}
