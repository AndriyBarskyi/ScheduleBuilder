package ua.edu.lnu.schedulebuilder.mapper;

import java.util.List;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import ua.edu.lnu.schedulebuilder.dto.TeacherLessonDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonSaveDTO;
import ua.edu.lnu.schedulebuilder.model.TeacherLesson;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeacherLessonMapper {

    TeacherLesson dtoToEntity(TeacherLessonDTO TeacherLessonDTO);

    TeacherLessonDTO entityToDto(TeacherLesson TeacherLesson);

    void updateTeacherLesson(
        @MappingTarget TeacherLesson TeacherLessonFromDB,
        TeacherLessonSaveDTO newTeacherLesson);

    @Mapping(target = "lessonDTO", source = "lesson")
    @Mapping(target = "teacherDTO", source = "teacher")
    List<TeacherLessonDTO> entitiesToDtos(List<TeacherLesson> all);

    @Mapping(target = "lesson.id", source = "lessonId")
    @Mapping(target = "teacher.id", source = "teacherId")
    TeacherLesson saveDtoToEntity(
        TeacherLessonSaveDTO newTeacherLesson);

    @Mapping(target = "lessonId", source = "lesson.id")
    @Mapping(target = "teacherId", source = "teacher.id")
    TeacherLessonSaveDTO entityToSaveDto(TeacherLesson save);
}
