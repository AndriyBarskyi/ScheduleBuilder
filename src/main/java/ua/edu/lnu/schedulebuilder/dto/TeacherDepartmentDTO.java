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
public class TeacherDepartmentDTO {
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @Positive
    private Double budgetRate;
    @NotNull
    @Positive
    private Double extraRate;
    @NotNull
    @NotEmpty
    private TeacherDTO teacherDTO;
    @NotNull
    @NotEmpty
    private DepartmentDTO departmentDTO;
}
