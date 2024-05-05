package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.LessonDTO;
import ua.edu.lnu.schedulebuilder.model.Lesson;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface LessonMapper {
    Lesson dtoToEntity(LessonDTO lessonDTO);

    LessonDTO entityToDto(Lesson lesson);

    void updateLesson(@MappingTarget Lesson lessonFromDB,
        LessonDTO newLesson);

    List<LessonDTO> entitiesToDtos(List<Lesson> lessons);
}
