package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;

public interface DepartmentService {

    List<DepartmentDTO> getAllDepartmentsByFacultyId(String facultyId);

    DepartmentDTO getDepartmentById(String id);

    void deleteDepartment(String id);

    DepartmentDTO updateDepartment(DepartmentDTO newDepartment,
        String id);

    DepartmentDTO addNewDepartment(DepartmentDTO newDepartment);
}
