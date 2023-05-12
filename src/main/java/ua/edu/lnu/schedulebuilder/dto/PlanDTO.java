package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    private Integer groups;
    @NotNull
    private Integer students;
    @NotNull
    private Integer lectures;
    @NotNull
    private Integer practicalClasses;
    @NotNull
    private Integer laboratoryClasses;
    @NotNull
    private Integer exams;
    @NotNull
    private Integer passFailCourses;
    @NotNull
    private Integer courseWorks;
    @NotNull
    private Integer diplomaWorks;
    @NotNull
    private Integer practices;
    @NotNull
    private Integer consultations;
    @NotNull
    private Integer others;
    @NotNull
    @NotEmpty
    private String academicYearId;
    @NotNull
    @NotEmpty
    private String departmentId;
}
