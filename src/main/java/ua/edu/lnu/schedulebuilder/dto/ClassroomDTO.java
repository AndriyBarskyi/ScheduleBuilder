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

public class ClassroomDTO {
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    @Positive
    private String number;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    @Positive
    private Integer capacity;
    @NotNull
    @NotEmpty
    private String type;
    @NotNull
    @NotEmpty
    private String facultyId;
}
