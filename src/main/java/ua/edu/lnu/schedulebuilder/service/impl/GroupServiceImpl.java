package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.GroupDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.GroupMapper;
import ua.edu.lnu.schedulebuilder.repository.GroupRepository;
import ua.edu.lnu.schedulebuilder.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

    static final String GROUP_NOT_FOUND_BY_ID = "Group not found by id: ";
    private final GroupRepository groupRepository;
    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository,
        GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupDTO getGroupById(String id) {
        checkThatGroupExists(id);
        return groupMapper.entityToDto(
            groupRepository.getReferenceById(id));
    }

    @Override
    public void deleteGroup(String id) {
        checkThatGroupExists(id);
        groupRepository.deleteById(id);
    }

    @Override
    public GroupDTO updateGroup(GroupDTO newGroup, String id) {
        checkThatGroupExists(id);
        return groupRepository.findById(id)
            .map(group -> {
                groupMapper.updateGroup(group, newGroup);
                return groupMapper.entityToDto(groupRepository
                    .save(group));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public GroupDTO addNewGroup(GroupDTO newGroup) {
        return groupMapper.entityToDto(
            groupRepository.save(
                groupMapper.dtoToEntity(newGroup)
            )
        );
    }

    @Override
    public List<GroupDTO> getAllGroupsByDepartmentIdAndAcademicYear(
        String departmentId, Integer academicYear) {
        return groupMapper.entitiesToDtos(
            groupRepository.findAllByDepartmentIdAndAcademicYear(
                departmentId, academicYear));
    }

    @Override
    public List<GroupDTO> getAllGroupsByDepartmentIdAndAcademicYearAndStudyingYear(
        String departmentId, Integer academicYear, Integer studyingYear) {
        return groupMapper.entitiesToDtos(
            groupRepository.findAllByDepartmentIdAAndAcademicYearAndStudyingYear(
                departmentId, academicYear, studyingYear));
    }

    @Override public List<GroupDTO> getAllGroups() {
        return groupMapper.entitiesToDtos(groupRepository.findAll());
    }

    private void checkThatGroupExists(String id) {
        if (!groupRepository.existsById(id)) {
            throw new EntityNotExistsException(GROUP_NOT_FOUND_BY_ID + id);
        }
    }
}
