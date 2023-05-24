package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.FacultyDTO;
import ua.edu.lnu.schedulebuilder.model.Faculty;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface FacultyMapper {
    Faculty dtoToEntity(FacultyDTO teacherDTO);

    FacultyDTO entityToDto(Faculty teacher);

    void updateFaculty(@MappingTarget Faculty teacherFromDB,
        FacultyDTO newFaculty);

    List<FacultyDTO> entitiesToDtos(List<Faculty> faculties);
}
