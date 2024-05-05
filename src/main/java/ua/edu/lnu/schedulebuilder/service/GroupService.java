package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.GroupDTO;

public interface GroupService {

    GroupDTO getGroupById(String id);

    void deleteGroup(String id);

    GroupDTO updateGroup(GroupDTO newGroup,
        String id);

    GroupDTO addNewGroup(GroupDTO newGroup);

    List<GroupDTO> getAllGroupsByDepartmentIdAndAcademicYearAndStudyingYear(
        String departmentId, Integer academicYear, Integer studyingYear);

    List<GroupDTO> getAllGroupsByDepartmentIdAndAcademicYear(
        String departmentId, Integer academicYear);

    List<GroupDTO> getAllGroups();
}
