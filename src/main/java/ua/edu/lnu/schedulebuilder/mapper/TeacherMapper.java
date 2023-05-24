package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeacherDTO;
import ua.edu.lnu.schedulebuilder.model.Teacher;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherMapper {
    Teacher dtoToEntity(TeacherDTO teacherDTO);

    TeacherDTO entityToDto(Teacher teacher);

    void updateTeacher(@MappingTarget Teacher teacherFromDB,
        TeacherDTO newTeacher);

    List<TeacherDTO> entitiesToDtos(List<Teacher> teachers);
}
