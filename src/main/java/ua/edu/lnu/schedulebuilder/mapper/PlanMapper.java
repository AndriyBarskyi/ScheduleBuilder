package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.model.Plan;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanMapper {
    @Mapping(target = "faculty.id", source = "facultyId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    Plan dtoToEntity(PlanDTO teacherDTO);

    @Mapping(target = "facultyId", source = "faculty.id")
    @Mapping(target = "academicYearId", source = "academicYear.id")
    PlanDTO entityToDto(Plan teacher);

    @Mapping(target = "faculty.id", source = "facultyId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    void updatePlan(@MappingTarget Plan teacherFromDB,
        PlanDTO newPlan);
}
