package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachersLoadDTO {
    private String id;

    @NotNull
    @NotEmpty
    private String facultyAbbr;
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
    private Integer lecturesExtramural;
    @NotNull
    private Integer practicalClassesExtramural;
    @NotNull
    private Integer laboratoryClassesExtramural;
    @NotNull
    private Integer examsExtramural;
    @NotNull
    private Integer passFailCoursesExtramural;
    @NotNull
    private Integer controlWorks;
    @NotNull
    private Integer courseWorks;
    @NotNull
    private Integer diplomaWorks;
    @NotNull
    private Integer pedagogicPractices;
    @NotNull
    private Integer studyPractices;
    @NotNull
    private Integer industrialPractices;
    @NotNull
    private Integer DEKs;
    @NotNull
    private Integer postgrad;
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
    @NotNull
    @NotEmpty
    private String teacherId;
    @NotNull
    @NotEmpty
    private String planId;
}
