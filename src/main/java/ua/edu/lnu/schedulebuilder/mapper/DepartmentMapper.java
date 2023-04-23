package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;
import ua.edu.lnu.schedulebuilder.model.Department;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DepartmentMapper {
    @Mapping(target = "faculty.id", source = "facultyId")
    Department dtoToEntity(DepartmentDTO teacherDTO);

    @Mapping(target = "facultyId", source = "faculty.id")
    DepartmentDTO entityToDto(Department teacher);

    @Mapping(target = "faculty.id", source = "facultyId")
    void updateDepartment(@MappingTarget Department teacherFromDB,
        DepartmentDTO newDepartment);
}
