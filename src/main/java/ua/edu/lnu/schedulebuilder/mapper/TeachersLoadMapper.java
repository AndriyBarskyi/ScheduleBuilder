package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.model.TeachersLoad;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeachersLoadMapper {
    TeachersLoad dtoToEntity(TeachersLoadDTO teacherDTO);

    TeachersLoadDTO entityToDto(TeachersLoad teacher);

    void updateTeachersLoad(@MappingTarget TeachersLoad teacherFromDB,
        TeachersLoadDTO newTeachersLoad);
}
