package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.GroupDTO;
import ua.edu.lnu.schedulebuilder.model.Group;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface GroupMapper {
    Group dtoToEntity(GroupDTO groupDTO);

    GroupDTO entityToDto(Group group);

    void updateGroup(@MappingTarget Group groupFromDB,
        GroupDTO newGroup);

    List<GroupDTO> entitiesToDtos(List<Group> groups);
}
