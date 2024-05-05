package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.edu.lnu.schedulebuilder.model.LessonType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {

    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String subject;
    @NotNull
    @NotEmpty
    private LessonType type;
    @NotNull
    @Positive
    private Integer lessonNumber;
    @NotNull
    @NotEmpty
    private String dayOfWeek;
    private boolean denominator;
    @NotNull
    @NotEmpty
    private String groupId;
    @NotNull
    @NotEmpty
    private String classroomId;
    @NotNull
    @NotEmpty
    private String scheduleId;

}
