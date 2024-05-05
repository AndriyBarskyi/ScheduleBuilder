package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    @Query("SELECT s FROM Schedule s WHERE s.department.id = ?1")
    List<Schedule> findAllByDepartmentId(String departmentId);

    @Query("SELECT s FROM Schedule s WHERE s.academicYear.id = ?1 AND s.department.id = ?2 AND s.semester = ?3")
    Schedule findByAcademicYearIdAndDepartmentIdAndSemester(
        String academicYearId, String departmentId,
        String semester);
}
