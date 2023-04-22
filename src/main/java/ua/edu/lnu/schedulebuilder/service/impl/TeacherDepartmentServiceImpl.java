package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.TeacherDepartmentMapper;
import ua.edu.lnu.schedulebuilder.repository.TeacherDepartmentRepository;
import ua.edu.lnu.schedulebuilder.service.TeacherDepartmentService;

@Service
public class TeacherDepartmentServiceImpl implements TeacherDepartmentService {

    private static final String TEACHER_DEPARTMENT_NOT_FOUND_BY_ID = "TeacherDepartment not found by id: ";
    private final TeacherDepartmentRepository teacherDepartmentRepository;
    private final TeacherDepartmentMapper teacherDepartmentMapper;

    @Autowired
    public TeacherDepartmentServiceImpl(TeacherDepartmentRepository teacherDepartmentRepository,
        TeacherDepartmentMapper teacherDepartmentMapper) {
        this.teacherDepartmentRepository = teacherDepartmentRepository;
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
    public TeacherDepartmentDTO updateTeacherDepartment(TeacherDepartmentDTO newTeacherDepartment, String id) {
        checkThatTeacherDepartmentExists(id);
        return teacherDepartmentRepository.findById(id)
            .map(teacherDepartment -> {
                teacherDepartmentMapper.updateTeacherDepartment(teacherDepartment, newTeacherDepartment);
                return teacherDepartmentMapper.entityToDto(teacherDepartmentRepository
                    .save(teacherDepartment));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeacherDepartmentDTO addNewTeacherDepartment(TeacherDepartmentDTO newTeacherDepartment) {
        return teacherDepartmentMapper.entityToDto(
            teacherDepartmentRepository.save(
                teacherDepartmentMapper.dtoToEntity(newTeacherDepartment)
            )
        );
    }

    private void checkThatTeacherDepartmentExists(String id) {
        if (!teacherDepartmentRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHER_DEPARTMENT_NOT_FOUND_BY_ID + id);
        }
    }
}
