package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, String> {

    @Query("SELECT p FROM Plan p WHERE p.faculty.id = ?1 and p.academicYear.id = ?2")
    Plan findPlanByFacultyIdAndAcademicYearId(String facultyId,
        String academicYear);
}
