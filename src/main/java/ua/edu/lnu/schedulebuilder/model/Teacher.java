package ua.edu.lnu.schedulebuilder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEACHER")

public class Teacher {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String position;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<TeacherDepartment> teacherDepartments;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<TeachersLoad> teachersLoads;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.REMOVE)
    private List<TeacherLesson> teacherLessons;
}
