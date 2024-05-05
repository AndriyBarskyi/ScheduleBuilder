package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.ScheduleDTO;

public interface ScheduleService {

    ScheduleDTO getScheduleById(String id);

    void deleteSchedule(String id);

    ScheduleDTO updateSchedule(ScheduleDTO newSchedule,
        String id);

    ScheduleDTO addNewSchedule(ScheduleDTO newSchedule);

    List<ScheduleDTO> getAllSchedulesByDepartmentId(String departmentId);

    ScheduleDTO getScheduleByAcademicYearIdAndDepartmentIdAndSemester(
        String academicYearId, String departmentId, String semester);

    List<ScheduleDTO> getAllSchedules();
}
