package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.TeacherDTO;

public interface TeacherService {

    TeacherDTO getTeacherById(String id);

    void deleteTeacher(String id);

    TeacherDTO updateTeacher(TeacherDTO newTeacher,
        String id);

    TeacherDTO addNewTeacher(TeacherDTO newTeacher);

    List<TeacherDTO> getAllTeachersByDepartmentId(String departmentId);
}
