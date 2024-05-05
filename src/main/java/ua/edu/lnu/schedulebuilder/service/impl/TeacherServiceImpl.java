package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.TeacherDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.TeacherMapper;
import ua.edu.lnu.schedulebuilder.repository.TeacherRepository;
import ua.edu.lnu.schedulebuilder.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    static final String TEACHER_NOT_FOUND_BY_ID = "Teacher not found by id: ";
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository,
        TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public TeacherDTO getTeacherById(String id) {
        checkThatTeacherExists(id);
        return teacherMapper.entityToDto(
            teacherRepository.getReferenceById(id));
    }

    @Override
    public void deleteTeacher(String id) {
        checkThatTeacherExists(id);
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO newTeacher, String id) {
        checkThatTeacherExists(id);
        return teacherRepository.findById(id)
            .map(teacher -> {
                teacherMapper.updateTeacher(teacher, newTeacher);
                return teacherMapper.entityToDto(teacherRepository
                    .save(teacher));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeacherDTO addNewTeacher(TeacherDTO newTeacher) {
        return teacherMapper.entityToDto(
            teacherRepository.save(
                teacherMapper.dtoToEntity(newTeacher)
            )
        );
    }

    @Override
    public List<TeacherDTO> getAllTeachersByDepartmentId(String departmentId) {
        return teacherMapper.entitiesToDtos(
            teacherRepository.findAllByDepartmentId(departmentId));
    }

    @Override public List<TeacherDTO> getAllTeachers() {
        return teacherMapper.entitiesToDtos(teacherRepository.findAll());
    }

    private void checkThatTeacherExists(String id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHER_NOT_FOUND_BY_ID + id);
        }
    }
}
