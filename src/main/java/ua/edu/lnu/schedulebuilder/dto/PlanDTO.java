package ua.edu.lnu.schedulebuilder.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String department;
}
