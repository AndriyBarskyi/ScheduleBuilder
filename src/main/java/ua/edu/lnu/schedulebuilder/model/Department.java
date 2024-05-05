package ua.edu.lnu.schedulebuilder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DEPARTMENT")

public class Department {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id", foreignKey = @ForeignKey(name = "fk_department_faculty"))
    private Faculty faculty;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<TeacherDepartment> teacherDepartments;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<TeachersLoad> teachersLoads;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Plan> plans;

    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Group> groups;
}
