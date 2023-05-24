package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.TeachersLoad;

public interface TeachersLoadRepository
    extends JpaRepository<TeachersLoad, String> {

    @Query("SELECT t FROM TeachersLoad t WHERE t.department.id = ?1 AND t.teacher.id = ?2 AND t.academicYear.id = ?3")
    TeachersLoad findByDepartmentIdAndTeacherIdAndAcademicYearId(
        String facultyId, String teacherId,
        String academicYearId);
}
