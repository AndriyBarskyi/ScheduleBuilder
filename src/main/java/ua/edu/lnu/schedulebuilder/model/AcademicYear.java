package ua.edu.lnu.schedulebuilder.model;

import java.time.LocalDate;
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
@Table(name = "ACADEMIC_YEAR")

public class AcademicYear {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private LocalDate startYear;

    @Column(nullable = false)
    private LocalDate endYear;

    @OneToMany(mappedBy = "academicYear", cascade = CascadeType.REMOVE)
    private List<Plan> plans;

    @OneToMany(mappedBy = "academicYear", cascade = CascadeType.REMOVE)
    private List<TeachersLoad> teachersLoads;

    @OneToMany(mappedBy = "academicYear", cascade = CascadeType.REMOVE)
    private List<Group> groups;
}
