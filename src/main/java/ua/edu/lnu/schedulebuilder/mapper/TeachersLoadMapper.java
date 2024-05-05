package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.model.TeachersLoad;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeachersLoadMapper {
    @Mapping(target = "teacher.id", source = "teacherId")
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    TeachersLoad dtoToEntity(TeachersLoadDTO teacherDTO);

    @Mapping(target = "teacherId", source = "teacher.id")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "academicYearId", source = "academicYear.id")
    TeachersLoadDTO entityToDto(TeachersLoad teacher);

    @Mapping(target = "teacher.id", source = "teacherId")
    @Mapping(target = "department.id", source = "departmentId")
    @Mapping(target = "academicYear.id", source = "academicYearId")
    void updateTeachersLoad(@MappingTarget TeachersLoad teacherFromDB,
        TeachersLoadDTO newTeachersLoad);

    List<TeachersLoadDTO> entitiesToDtos(List<TeachersLoad> teachersLoadList);
}
