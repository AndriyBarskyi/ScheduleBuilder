package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.ScheduleDTO;
import ua.edu.lnu.schedulebuilder.model.Schedule;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ScheduleMapper {
    Schedule dtoToEntity(ScheduleDTO scheduleDTO);

    ScheduleDTO entityToDto(Schedule schedule);

    void updateSchedule(@MappingTarget Schedule scheduleFromDB,
        ScheduleDTO newSchedule);

    List<ScheduleDTO> entitiesToDtos(List<Schedule> schedules);
}
