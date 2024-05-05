package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherLessonDTO {
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private TeacherDTO teacherDTO;
    @NotNull
    @NotEmpty
    private LessonDTO lessonDTO;
}
