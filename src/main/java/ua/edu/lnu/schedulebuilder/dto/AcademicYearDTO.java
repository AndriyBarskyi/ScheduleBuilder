package ua.edu.lnu.schedulebuilder.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcademicYearDTO {
    private String id;
    @NotNull
    private LocalDate startYear;
    @NotNull
    private LocalDate endYear;
}
