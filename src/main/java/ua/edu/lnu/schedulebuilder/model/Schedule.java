package ua.edu.lnu.schedulebuilder.model;

import java.util.List;

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
@Table(name = "SСHEDULE")
public class Schedule {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @ManyToOne
    @JoinColumn(name = "academic_year_id", foreignKey = @ForeignKey(name = "fk_schedule_academic_year"))
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "fk_schedule_department"))
    private Department department;

    @OneToMany(mappedBy = "schedule")
    private List<Lesson> lessons;
}
