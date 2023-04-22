package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.model.Classroom;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ClassroomMapper {
    Classroom dtoToEntity(ClassroomDTO teacherDTO);

    ClassroomDTO entityToDto(Classroom teacher);

    void updateClassroom(@MappingTarget Classroom teacherFromDB,
        ClassroomDTO newClassroom);
}
