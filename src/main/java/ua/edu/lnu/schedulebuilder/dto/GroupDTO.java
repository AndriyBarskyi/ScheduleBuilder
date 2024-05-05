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
public class GroupDTO {

    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String groupName;
    @NotNull
    @NotEmpty
    @Positive
    private Integer studyingYear;
    @NotNull
    @NotEmpty
    @Positive
    private Integer studentCount;
    @NotNull
    @NotEmpty
    private String departmentId;
    @NotNull
    @NotEmpty
    private String academicYearId;

}
