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
@Table(name = "LESSON")
public class Lesson {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "type", nullable = false)
    private LessonType type;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "day_of_week", nullable = false)
    private WeekDay dayOfWeek;

    @Column(name = "denominator")
    private boolean denominator;

    @ManyToOne
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "fk_lesson_group"))
    private Group group;

    @ManyToOne
    @JoinColumn(name = "classroom_id", foreignKey = @ForeignKey(name = "fk_lesson_classroom"))
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name = "schedule_id", foreignKey = @ForeignKey(name = "fk_lesson_schedule"))
    private Schedule schedule;

    @OneToMany(mappedBy = "lesson")
    private List<TeacherLesson> teacherLessons;
}
