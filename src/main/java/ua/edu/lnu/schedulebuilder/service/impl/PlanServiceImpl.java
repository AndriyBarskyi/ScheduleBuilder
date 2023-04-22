package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.PlanMapper;
import ua.edu.lnu.schedulebuilder.repository.PlanRepository;
import ua.edu.lnu.schedulebuilder.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

    private static final String PLAN_NOT_FOUND_BY_ID = "Plan not found by id: ";
    private final PlanRepository planRepository;
    private final PlanMapper planMapper;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository,
        PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.planMapper = planMapper;
    }

    @Override
    public PlanDTO getPlanById(String id) {
        checkThatPlanExists(id);
        return planMapper.entityToDto(
            planRepository.getReferenceById(id));
    }

    @Override
    public void deletePlan(String id) {
        checkThatPlanExists(id);
        planRepository.deleteById(id);
    }

    @Override
    public PlanDTO updatePlan(PlanDTO newPlan, String id) {
        checkThatPlanExists(id);
        return planRepository.findById(id)
            .map(plan -> {
                planMapper.updatePlan(plan, newPlan);
                return planMapper.entityToDto(planRepository
                    .save(plan));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public PlanDTO addNewPlan(PlanDTO newPlan) {
        return planMapper.entityToDto(
            planRepository.save(
                planMapper.dtoToEntity(newPlan)
            )
        );
    }

    private void checkThatPlanExists(String id) {
        if (!planRepository.existsById(id)) {
            throw new EntityNotExistsException(PLAN_NOT_FOUND_BY_ID + id);
        }
    }
}
