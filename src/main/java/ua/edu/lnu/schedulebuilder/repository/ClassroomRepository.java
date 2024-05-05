package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {

    @Query("SELECT c FROM Classroom c WHERE c.faculty.id = ?1")
    List<Classroom> findAllByFacultyId(String facultyId);
}
