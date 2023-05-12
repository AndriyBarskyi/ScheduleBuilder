package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDepartmentDTO {
    private String id;

    @NotNull
    private Double rate;
    @NotNull
    @NotEmpty
    private String teacherId;
    @NotNull
    @NotEmpty
    private String departmentId;
}
