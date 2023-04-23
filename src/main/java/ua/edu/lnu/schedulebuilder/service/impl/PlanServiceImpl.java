package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.PlanMapper;
import ua.edu.lnu.schedulebuilder.repository.AcademicYearRepository;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.PlanRepository;
import ua.edu.lnu.schedulebuilder.service.PlanService;

import static ua.edu.lnu.schedulebuilder.service.impl.AcademicYearServiceImpl.ACADEMIC_YEAR_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.DepartmentServiceImpl.DEPARTMENT_NOT_FOUND_BY_ID;

@Service
public class PlanServiceImpl implements PlanService {

    static final String PLAN_NOT_FOUND_BY_ID = "Plan not found by id: ";
    private final PlanRepository planRepository;
    private final DepartmentRepository departmentRepository;
    private final AcademicYearRepository academicYearRepository;
    private final PlanMapper planMapper;

    @Autowired
    public PlanServiceImpl(PlanRepository planRepository,
        DepartmentRepository departmentRepository,
        AcademicYearRepository academicYearRepository,
        PlanMapper planMapper) {
        this.planRepository = planRepository;
        this.departmentRepository = departmentRepository;
        this.academicYearRepository = academicYearRepository;
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
        checkThatDepartmentExists(newPlan.getDepartmentId());
        checkThatAcademicYearExists(newPlan.getAcademicYearId());
        return planRepository.findById(id)
            .map(plan -> {
                planMapper.updatePlan(plan, newPlan);
                return planMapper.entityToDto(planRepository
                    .save(plan));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public PlanDTO addNewPlan(PlanDTO newPlan) {
        checkThatDepartmentExists(newPlan.getDepartmentId());
        checkThatAcademicYearExists(newPlan.getAcademicYearId());
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

    private void checkThatDepartmentExists(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotExistsException(DEPARTMENT_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatAcademicYearExists(String id) {
        if (!academicYearRepository.existsById(id)) {
            throw new EntityNotExistsException(ACADEMIC_YEAR_NOT_FOUND_BY_ID + id);
        }
    }
}
