package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachersLoadDTO {
    @NotNull
    @NotEmpty
    private String id;
    @NotNull
    @NotEmpty
    private String subject;
    @NotNull
    @NotEmpty
    private String course;
    @NotNull
    @Positive
    private Integer semester;
    @NotNull
    @NotEmpty
    private String facultyAbbr;
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
    private Integer lecturesExtramural;
    @NotNull
    @PositiveOrZero
    private Integer practicalClassesExtramural;
    @NotNull
    @PositiveOrZero
    private Integer laboratoryClassesExtramural;
    @NotNull
    @PositiveOrZero
    private Integer examsExtramural;
    @NotNull
    @PositiveOrZero
    private Integer passFailCoursesExtramural;
    @NotNull
    @PositiveOrZero
    private Integer consultationsExtramural;
    @NotNull
    @PositiveOrZero
    private Integer controlWorks;
    @NotNull
    @PositiveOrZero
    private Integer courseWorks;
    @NotNull
    @PositiveOrZero
    private Integer diplomaWorks;
    @NotNull
    @PositiveOrZero
    private Integer pedagogicPractices;
    @NotNull
    @PositiveOrZero
    private Integer studyPractices;
    @NotNull
    @PositiveOrZero
    private Integer industrialPractices;
    @NotNull
    @PositiveOrZero
    private Integer deks;
    @NotNull
    @PositiveOrZero
    private Integer postgrad;
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
    private String departmentId;
    @NotNull
    @NotEmpty
    private String teacherId;
}
