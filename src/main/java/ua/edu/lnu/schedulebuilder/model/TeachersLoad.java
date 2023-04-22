package ua.edu.lnu.schedulebuilder.model;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TeachersLoad")

public class TeachersLoad {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String facultyAbbr;
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
    private Integer lecturesExtramural;
    @Column(nullable = false)
    private Integer practicalClassesExtramural;
    @Column(nullable = false)
    private Integer laboratoryClassesExtramural;
    @Column(nullable = false)
    private Integer examsExtramural;
    @Column(nullable = false)
    private Integer passFailCoursesExtramural;
    @Column(nullable = false)
    private Integer controlWorks;
    @Column(nullable = false)
    private Integer courseWorks;
    @Column(nullable = false)
    private Integer diplomaWorks;
    @Column(nullable = false)
    private Integer pedagogicPractices;
    @Column(nullable = false)
    private Integer studyPractices;
    @Column(nullable = false)
    private Integer industrialPractices;
    @Column(nullable = false)
    private Integer DEKs;
    @Column(nullable = false)
    private Integer postgrad;
    @Column(nullable = false)
    private Integer consultations;
    @Column(nullable = false)
    private Integer others;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", foreignKey = @ForeignKey(name = "fk_load_academic_year"))
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "fk_load_department"))
    private Department department;

    @ManyToOne
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_load_teacher"))
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "plan_id", foreignKey = @ForeignKey(name = "fk_load_plan"))
    private Plan plan;
}
