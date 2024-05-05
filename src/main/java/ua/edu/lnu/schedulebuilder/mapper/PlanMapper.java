package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.model.Plan;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanMapper {
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    Plan dtoToEntity(PlanDTO teacherDTO);

    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "academicYearId", source = "academicYear.id")
    PlanDTO entityToDto(Plan teacher);

    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    void updatePlan(@MappingTarget Plan teacherFromDB,
        PlanDTO newPlan);

    List<PlanDTO> entitiesToDtos(List<Plan> plans);
}
