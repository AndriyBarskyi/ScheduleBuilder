package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentSaveDTO;

public interface TeacherDepartmentService {

    TeacherDepartmentDTO getTeacherDepartmentById(String id);

    void deleteTeacherDepartment(String id);

    TeacherDepartmentDTO updateTeacherDepartment(
        TeacherDepartmentDTO newTeacherDepartment,
        String id);

    TeacherDepartmentSaveDTO addNewTeacherDepartment(
        TeacherDepartmentSaveDTO newTeacherDepartment);

    List<TeacherDepartmentDTO> getAllTeacherDepartments();
}
