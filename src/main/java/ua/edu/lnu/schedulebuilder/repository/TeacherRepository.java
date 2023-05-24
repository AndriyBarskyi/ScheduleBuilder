package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

    @Query("SELECT t from Teacher t "
            + "join TeacherDepartment td "
            + "where td.teacher.id = t.id and td.department.id = ?1"
    )
    List<Teacher> findAllByDepartmentId(String departmentId);
}
