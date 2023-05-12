package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.TeacherDepartmentMapper;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherDepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherRepository;
import ua.edu.lnu.schedulebuilder.service.TeacherDepartmentService;

import static ua.edu.lnu.schedulebuilder.service.impl.DepartmentServiceImpl.DEPARTMENT_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.TeacherServiceImpl.TEACHER_NOT_FOUND_BY_ID;

@Service
public class TeacherDepartmentServiceImpl implements TeacherDepartmentService {

    static final String TEACHER_DEPARTMENT_NOT_FOUND_BY_ID =
        "TeacherDepartment not found by id: ";
    private final TeacherDepartmentRepository teacherDepartmentRepository;
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    private final TeacherDepartmentMapper teacherDepartmentMapper;

    @Autowired
    public TeacherDepartmentServiceImpl(
        TeacherDepartmentRepository teacherDepartmentRepository,
        TeacherRepository teacherRepository,
        DepartmentRepository departmentRepository,
        TeacherDepartmentMapper teacherDepartmentMapper) {
        this.teacherDepartmentRepository = teacherDepartmentRepository;
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.teacherDepartmentMapper = teacherDepartmentMapper;
    }

    @Override
    public TeacherDepartmentDTO getTeacherDepartmentById(String id) {
        checkThatTeacherDepartmentExists(id);
        return teacherDepartmentMapper.entityToDto(
            teacherDepartmentRepository.getReferenceById(id));
    }

    @Override
    public void deleteTeacherDepartment(String id) {
        checkThatTeacherDepartmentExists(id);
        teacherDepartmentRepository.deleteById(id);
    }

    @Override
    public TeacherDepartmentDTO updateTeacherDepartment(
        TeacherDepartmentDTO newTeacherDepartment, String id) {
        checkThatTeacherDepartmentExists(id);
        checkThatTeacherExists(newTeacherDepartment.getTeacherId());
        checkThatDepartmentExists(newTeacherDepartment.getDepartmentId());
        return teacherDepartmentRepository.findById(id)
            .map(teacherDepartment -> {
                teacherDepartmentMapper.updateTeacherDepartment(
                    teacherDepartment, newTeacherDepartment);
                return teacherDepartmentMapper.entityToDto(
                    teacherDepartmentRepository
                        .save(teacherDepartment));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeacherDepartmentDTO addNewTeacherDepartment(
        TeacherDepartmentDTO newTeacherDepartment) {
        checkThatTeacherExists(newTeacherDepartment.getTeacherId());
        checkThatDepartmentExists(newTeacherDepartment.getDepartmentId());
        return teacherDepartmentMapper.entityToDto(
            teacherDepartmentRepository.save(
                teacherDepartmentMapper.dtoToEntity(newTeacherDepartment)
            )
        );
    }

    private void checkThatTeacherDepartmentExists(String id) {
        if (!teacherDepartmentRepository.existsById(id)) {
            throw new EntityNotExistsException(
                TEACHER_DEPARTMENT_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatDepartmentExists(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotExistsException(DEPARTMENT_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatTeacherExists(String id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHER_NOT_FOUND_BY_ID + id);
        }
    }
}
