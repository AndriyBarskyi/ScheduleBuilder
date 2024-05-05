package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;

public interface TeachersLoadService {

    TeachersLoadDTO getTeachersLoadById(String id);

    void deleteTeachersLoad(String id);

    TeachersLoadDTO updateTeachersLoad(TeachersLoadDTO newTeachersLoad,
        String id);

    TeachersLoadDTO addNewTeachersLoad(TeachersLoadDTO newTeachersLoad);

    List<TeachersLoadDTO> getTeachersLoadsByFacultyIdAndTeacherIdAndAcademicYearId(
        String departmentId, String teacherId, String academicYearId);

    List<TeachersLoadDTO> getAllTeachersLoads();
}
