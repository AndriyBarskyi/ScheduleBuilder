package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClassroomDTO {
    private String id;
    @NotNull
    @NotEmpty
    private String number;
    @NotNull
    @NotEmpty
    private String address;
    @NotNull
    private Integer capacity;
    @NotNull
    @NotEmpty
    private String type;
    @NotNull
    @NotEmpty
    private String facultyId;
}
