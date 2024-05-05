package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDTO {

    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @Positive
    private Integer semester;
    @NotNull
    @NotEmpty
    private String academicYearId;
    @NotNull
    @NotEmpty
    private String departmentId;

}
