package ua.edu.lnu.schedulebuilder.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.model.Plan;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlanMapper {
    Plan dtoToEntity(PlanDTO teacherDTO);

    PlanDTO entityToDto(Plan teacher);

    void updatePlan(@MappingTarget Plan teacherFromDB,
        PlanDTO newPlan);
}
