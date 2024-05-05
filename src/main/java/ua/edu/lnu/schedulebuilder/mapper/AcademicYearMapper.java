package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.AcademicYearDTO;
import ua.edu.lnu.schedulebuilder.model.AcademicYear;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AcademicYearMapper {
    AcademicYear dtoToEntity(AcademicYearDTO teacherDTO);

    AcademicYearDTO entityToDto(AcademicYear teacher);

    void updateAcademicYear(@MappingTarget AcademicYear teacherFromDB,
        AcademicYearDTO newAcademicYear);

    List<AcademicYearDTO> entitiesToDtos(List<AcademicYear> academicYears);
}
