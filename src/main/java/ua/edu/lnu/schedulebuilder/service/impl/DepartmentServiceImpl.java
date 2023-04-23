package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.DepartmentMapper;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.FacultyRepository;
import ua.edu.lnu.schedulebuilder.service.DepartmentService;

import static ua.edu.lnu.schedulebuilder.service.impl.FacultyServiceImpl.FACULTY_NOT_FOUND_BY_ID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    static final String DEPARTMENT_NOT_FOUND_BY_ID = "Department not found by id: ";
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
        FacultyRepository facultyRepository,
        DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public DepartmentDTO getDepartmentById(String id) {
        checkThatDepartmentExists(id);
        return departmentMapper.entityToDto(
            departmentRepository.getReferenceById(id));
    }

    @Override
    public void deleteDepartment(String id) {
        checkThatDepartmentExists(id);
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentDTO newDepartment, String id) {
        checkThatDepartmentExists(id);
        checkThatFacultyExists(newDepartment.getFacultyId());
        return departmentRepository.findById(id)
            .map(department -> {
                departmentMapper.updateDepartment(department, newDepartment);
                return departmentMapper.entityToDto(departmentRepository
                    .save(department));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public DepartmentDTO addNewDepartment(DepartmentDTO newDepartment) {
        checkThatFacultyExists(newDepartment.getFacultyId());
        return departmentMapper.entityToDto(
            departmentRepository.save(
                departmentMapper.dtoToEntity(newDepartment)
            )
        );
    }

    private void checkThatDepartmentExists(String id) {
        if (!departmentRepository.existsById(id)) {
            throw new EntityNotExistsException(DEPARTMENT_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatFacultyExists(String id) {
        if (!facultyRepository.existsById(id)) {
            throw new EntityNotExistsException(
                FACULTY_NOT_FOUND_BY_ID + id);
        }
    }
}
