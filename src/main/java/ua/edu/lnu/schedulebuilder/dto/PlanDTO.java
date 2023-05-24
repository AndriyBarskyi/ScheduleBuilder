package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanDTO {
    private String id;

    @NotNull
    @NotEmpty
    private String course;
    @NotNull
    @NotEmpty
    private String facultyAbbr;
    @NotNull
    @PositiveOrZero
    private Integer groups;
    @NotNull
    @PositiveOrZero
    private Integer students;
    @NotNull
    @PositiveOrZero
    private Integer lectures;
    @NotNull
    @PositiveOrZero
    private Integer practicalClasses;
    @NotNull
    @PositiveOrZero
    private Integer laboratoryClasses;
    @NotNull
    @PositiveOrZero
    private Integer exams;
    @NotNull
    @PositiveOrZero
    private Integer passFailCourses;
    @NotNull
    @PositiveOrZero
    private Integer courseWorks;
    @NotNull
    @PositiveOrZero
    private Integer diplomaWorks;
    @NotNull
    @PositiveOrZero
    private Integer practices;
    @NotNull
    @PositiveOrZero
    private Integer consultations;
    @NotNull
    @PositiveOrZero
    private Integer others;
    @NotNull
    @NotEmpty
    private String academicYearId;
    @NotNull
    @NotEmpty
    private String facultyId;
}
