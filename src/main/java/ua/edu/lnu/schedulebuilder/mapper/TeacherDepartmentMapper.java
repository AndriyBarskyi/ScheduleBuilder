package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.model.TeacherDepartment;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherDepartmentMapper {
    TeacherDepartment dtoToEntity(TeacherDepartmentDTO teacherDTO);

    TeacherDepartmentDTO entityToDto(TeacherDepartment teacher);

    void updateTeacherDepartment(@MappingTarget TeacherDepartment teacherFromDB,
        TeacherDepartmentDTO newTeacherDepartment);
}
