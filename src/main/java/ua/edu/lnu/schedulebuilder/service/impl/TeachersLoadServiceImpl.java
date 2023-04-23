package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.TeachersLoadMapper;
import ua.edu.lnu.schedulebuilder.repository.AcademicYearRepository;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.PlanRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherRepository;
import ua.edu.lnu.schedulebuilder.repository.TeachersLoadRepository;
import ua.edu.lnu.schedulebuilder.service.TeachersLoadService;

import static ua.edu.lnu.schedulebuilder.service.impl.AcademicYearServiceImpl.ACADEMIC_YEAR_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.DepartmentServiceImpl.DEPARTMENT_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.PlanServiceImpl.PLAN_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.TeacherServiceImpl.TEACHER_NOT_FOUND_BY_ID;

@Service
public class TeachersLoadServiceImpl implements TeachersLoadService {

    static final String TEACHERS_LOAD_NOT_FOUND_BY_ID = "TeachersLoad not found by id: ";
    private final TeachersLoadRepository teachersLoadRepository;
    private final AcademicYearRepository academicYearRepository;
    private final DepartmentRepository departmentRepository;
    private final PlanRepository planRepository;
    private final TeacherRepository teacherRepository;
    private final TeachersLoadMapper teachersLoadMapper;

    @Autowired
    public TeachersLoadServiceImpl(TeachersLoadRepository teachersLoadRepository,
        AcademicYearRepository academicYearRepository,
        DepartmentRepository departmentRepository,
        TeacherRepository teacherRepository,
        PlanRepository planRepository,
        TeachersLoadMapper teachersLoadMapper) {
        this.teachersLoadRepository = teachersLoadRepository;
        this.academicYearRepository = academicYearRepository;
        this.departmentRepository = departmentRepository;
        this.teacherRepository = teacherRepository;
        this.planRepository = planRepository;
        this.teachersLoadMapper = teachersLoadMapper;
    }

    @Override
    public TeachersLoadDTO getTeachersLoadById(String id) {
        checkThatTeachersLoadExists(id);
        return teachersLoadMapper.entityToDto(
            teachersLoadRepository.getReferenceById(id));
    }

    @Override
    public void deleteTeachersLoad(String id) {
        checkThatTeachersLoadExists(id);
        teachersLoadRepository.deleteById(id);
    }

    @Override
    public TeachersLoadDTO updateTeachersLoad(TeachersLoadDTO newTeachersLoad, String id) {
        checkThatTeachersLoadExists(id);
        checkThatAcademicYearExists(newTeachersLoad.getAcademicYearId());
        checkThatDepartmentExists(newTeachersLoad.getDepartmentId());
        checkThatTeacherExists(newTeachersLoad.getTeacherId());
        checkThatPlanExists(newTeachersLoad.getPlanId());
        return teachersLoadRepository.findById(id)
            .map(teachersLoad -> {
                teachersLoadMapper.updateTeachersLoad(teachersLoad, newTeachersLoad);
                return teachersLoadMapper.entityToDto(teachersLoadRepository
                    .save(teachersLoad));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeachersLoadDTO addNewTeachersLoad(TeachersLoadDTO newTeachersLoad) {
        checkThatAcademicYearExists(newTeachersLoad.getAcademicYearId());
        checkThatDepartmentExists(newTeachersLoad.getDepartmentId());
        checkThatTeacherExists(newTeachersLoad.getTeacherId());
        checkThatPlanExists(newTeachersLoad.getPlanId());
        return teachersLoadMapper.entityToDto(
            teachersLoadRepository.save(
                teachersLoadMapper.dtoToEntity(newTeachersLoad)
            )
        );
    }

    private void checkThatTeachersLoadExists(String id) {
        if (!teachersLoadRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHERS_LOAD_NOT_FOUND_BY_ID + id);
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

    private void checkThatPlanExists(String id) {
        if (!planRepository.existsById(id)) {
            throw new EntityNotExistsException(PLAN_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatTeacherExists(String id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHER_NOT_FOUND_BY_ID + id);
        }
    }
}
