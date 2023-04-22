package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;

public interface TeacherDepartmentService {

    TeacherDepartmentDTO getTeacherDepartmentById(String id);

    void deleteTeacherDepartment(String id);

    TeacherDepartmentDTO updateTeacherDepartment(TeacherDepartmentDTO newTeacherDepartment,
        String id);

    TeacherDepartmentDTO addNewTeacherDepartment(TeacherDepartmentDTO newTeacherDepartment);
}
