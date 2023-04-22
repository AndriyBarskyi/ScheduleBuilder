package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO getDepartmentById(String id);

    void deleteDepartment(String id);

    DepartmentDTO updateDepartment(DepartmentDTO newDepartment,
        String id);

    DepartmentDTO addNewDepartment(DepartmentDTO newDepartment);
}
