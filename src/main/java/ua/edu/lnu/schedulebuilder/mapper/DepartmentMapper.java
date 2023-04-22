package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;
import ua.edu.lnu.schedulebuilder.model.Department;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface DepartmentMapper {
    Department dtoToEntity(DepartmentDTO teacherDTO);

    DepartmentDTO entityToDto(Department teacher);

    void updateDepartment(@MappingTarget Department teacherFromDB,
        DepartmentDTO newDepartment);
}
