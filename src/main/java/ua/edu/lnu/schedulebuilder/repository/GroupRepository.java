package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Group;

public interface GroupRepository extends JpaRepository<Group, String> {

    @Query("SELECT g FROM Group g "
        + "JOIN g.department d "
        + "JOIN g.academicYear ay "
        + "WHERE d.id = ?1 AND ay.id = ?2")
    List<Group> findAllByDepartmentIdAndAcademicYear(String departmentId,
        Integer academicYear);

    @Query("SELECT g FROM Group g "
        + "JOIN g.department d "
        + "JOIN g.academicYear ay "
        + "WHERE d.id = ?1 AND ay.id = ?2 AND g.studyingYear = ?3")
    List<Group> findAllByDepartmentIdAAndAcademicYearAndStudyingYear(
        String departmentId, Integer academicYear, Integer studyingYear);

}
