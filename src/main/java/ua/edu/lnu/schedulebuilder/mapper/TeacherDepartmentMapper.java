package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentSaveDTO;
import ua.edu.lnu.schedulebuilder.model.TeacherDepartment;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherDepartmentMapper {

    TeacherDepartment dtoToEntity(TeacherDepartmentDTO teacherDepartmentDTO);

    TeacherDepartmentDTO entityToDto(TeacherDepartment teacherDepartment);

    void updateTeacherDepartment(
        @MappingTarget TeacherDepartment teacherDepartmentFromDB,
        TeacherDepartmentDTO newTeacherDepartment);

    @Mapping(target = "departmentDTO", source = "department")
    @Mapping(target = "teacherDTO", source = "teacher")
    List<TeacherDepartmentDTO> entitiesToDtos(List<TeacherDepartment> all);

    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "teacher.id", source = "teacherId")
    TeacherDepartment saveDtoToEntity(
        TeacherDepartmentSaveDTO newTeacherDepartment);

    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    TeacherDepartmentSaveDTO entityToSaveDto(TeacherDepartment save);
}
