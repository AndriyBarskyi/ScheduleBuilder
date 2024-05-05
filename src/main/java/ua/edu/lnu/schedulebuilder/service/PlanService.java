package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;

public interface PlanService {

    PlanDTO getPlanById(String id);

    void deletePlan(String id);

    PlanDTO updatePlan(PlanDTO newPlan,
        String id);

    PlanDTO addNewPlan(PlanDTO newPlan);

    List<PlanDTO> getPlansByDepartmentIdAndAcademicYearId(String departmentId,
        String academicYearId);

    List<PlanDTO> getAllPlans();
}
