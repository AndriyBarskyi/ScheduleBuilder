package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentSaveDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.DepartmentMapper;
import ua.edu.lnu.schedulebuilder.mapper.TeacherDepartmentMapper;
import ua.edu.lnu.schedulebuilder.mapper.TeacherMapper;
import ua.edu.lnu.schedulebuilder.model.TeacherDepartment;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherDepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.TeacherRepository;
import ua.edu.lnu.schedulebuilder.service.TeacherDepartmentService;

import static ua.edu.lnu.schedulebuilder.service.impl.DepartmentServiceImpl.DEPARTMENT_NOT_FOUND_BY_ID;
import static ua.edu.lnu.schedulebuilder.service.impl.TeacherServiceImpl.TEACHER_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class TeacherDepartmentServiceImpl implements TeacherDepartmentService {

    static final String TEACHER_DEPARTMENT_NOT_FOUND_BY_ID =
        "TeacherDepartment not found by id: ";
    private final TeacherDepartmentRepository teacherDepartmentRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;
    private final TeacherDepartmentMapper teacherDepartmentMapper;

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
        checkThatTeacherExists(newTeacherDepartment.getTeacherDTO().getId());
        checkThatDepartmentExists(
            newTeacherDepartment.getDepartmentDTO().getId());
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
    public TeacherDepartmentSaveDTO addNewTeacherDepartment(
        TeacherDepartmentSaveDTO newTeacherDepartment) {
        checkThatTeacherExists(newTeacherDepartment.getTeacherId());
        checkThatDepartmentExists(newTeacherDepartment.getDepartmentId());
        return teacherDepartmentMapper.entityToSaveDto(
            teacherDepartmentRepository.save(
                teacherDepartmentMapper.saveDtoToEntity(newTeacherDepartment)
            )
        );
    }

    @Override public List<TeacherDepartmentDTO> getAllTeacherDepartments() {
        return this.entitiesToDtos(
            teacherDepartmentRepository.findAll());
    }

    public List<TeacherDepartmentDTO> entitiesToDtos(
        List<TeacherDepartment> all) {
        if (all == null) {
            return null;
        }

        List<TeacherDepartmentDTO> list =
            new ArrayList<TeacherDepartmentDTO>(all.size());
        for (TeacherDepartment teacherDepartment : all) {
            TeacherDepartmentDTO teacherDepartmentDTO =
                teacherDepartmentMapper.entityToDto(teacherDepartment);
            teacherDepartmentDTO.setTeacherDTO(
                teacherMapper.entityToDto(teacherDepartment.getTeacher()));
            teacherDepartmentDTO.setDepartmentDTO(departmentMapper.entityToDto(
                teacherDepartment.getDepartment()));
            list.add(teacherDepartmentDTO);
        }

        return list;
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
