package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.model.Classroom;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClassroomMapper {
    @Mapping(target = "faculty.id", source = "facultyId")
    Classroom dtoToEntity(ClassroomDTO teacherDTO);

    @Mapping(target = "facultyId", source = "faculty.id")
    ClassroomDTO entityToDto(Classroom teacher);

    @Mapping(target = "faculty.id", source = "facultyId")
    void updateClassroom(@MappingTarget Classroom teacherFromDB,
        ClassroomDTO newClassroom);

    List<ClassroomDTO> entitiesToDtos(List<Classroom> classrooms);
}
