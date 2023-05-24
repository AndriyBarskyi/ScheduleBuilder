package ua.edu.lnu.schedulebuilder.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TEACHER_DEPARTMENT")

public class TeacherDepartment {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private Double budgetRate;

    @Column(nullable = false)
    private Double extraRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id", foreignKey = @ForeignKey(name = "fk_d_teacher"))
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "fk_t_department"))
    private Department department;
}
