package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, String> {

    @Query("SELECT p FROM Plan p WHERE p.department.id = ?1 and p.academicYear.id = ?2")
    List<Plan> findPlansByDepartmentIdAndAcademicYearId(String departmentId,
        String academicYear);
}
