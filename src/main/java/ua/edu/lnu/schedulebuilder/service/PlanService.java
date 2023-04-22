package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;

public interface PlanService {

    PlanDTO getPlanById(String id);

    void deletePlan(String id);

    PlanDTO updatePlan(PlanDTO newPlan,
        String id);

    PlanDTO addNewPlan(PlanDTO newPlan);
}
