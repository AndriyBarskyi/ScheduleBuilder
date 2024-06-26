package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherLessonSaveDTO {
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String teacherId;
    @NotNull
    @NotEmpty
    private String lessonId;
}
