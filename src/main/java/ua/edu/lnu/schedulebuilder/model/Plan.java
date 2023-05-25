package ua.edu.lnu.schedulebuilder.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PLAN")

public class Plan {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String course;
    @Column(nullable = false)
    private String facultyAbbr;
    @Column(nullable = false)
    private Integer groups;
    @Column(nullable = false)
    private Integer students;
    @Column(nullable = false)
    private Integer lectures;
    @Column(nullable = false)
    private Integer practicalClasses;
    @Column(nullable = false)
    private Integer laboratoryClasses;
    @Column(nullable = false)
    private Integer exams;
    @Column(nullable = false)
    private Integer passFailCourses;
    @Column(nullable = false)
    private Integer courseWorks;
    @Column(nullable = false)
    private Integer diplomaWorks;
    @Column(nullable = false)
    private Integer practices;
    @Column(nullable = false)
    private Integer consultations;
    @Column(nullable = false)
    private Integer others;
    @Column(nullable = false)
    private Boolean isExtramural;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", foreignKey = @ForeignKey(name = "fk_plan_academic_year"))
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "fk_plan_faculty"))
    private Faculty faculty;
}
