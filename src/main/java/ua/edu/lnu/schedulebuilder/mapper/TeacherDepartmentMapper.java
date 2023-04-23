package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.model.TeacherDepartment;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherDepartmentMapper {
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "teacher.id", source = "teacherId")
    TeacherDepartment dtoToEntity(TeacherDepartmentDTO teacherDTO);

    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "departmentId", source = "department.id")
    TeacherDepartmentDTO entityToDto(TeacherDepartment teacher);

    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "teacher.id", source = "teacherId")
    void updateTeacherDepartment(@MappingTarget TeacherDepartment teacherFromDB,
        TeacherDepartmentDTO newTeacherDepartment);
}
