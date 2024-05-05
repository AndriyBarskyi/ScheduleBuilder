package ua.edu.lnu.schedulebuilder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.edu.lnu.schedulebuilder.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, String> {

    @Query("SELECT l FROM Lesson l WHERE l.group.id = ?1")
    List<Lesson> findAllByGroupId(String lessonId);

    @Query("SELECT CASE WHEN COUNT(tl) > 0 THEN TRUE ELSE FALSE END FROM TeacherLesson tl WHERE tl.teacher.id = ?1 AND tl.lesson.number = ?2 AND tl.lesson.dayOfWeek = ?3")
    Boolean teacherHasLessonAtThisTime(String teacherId, Integer lessonNumber,
        String dayOfWeek);

    @Query("SELECT CASE WHEN COUNT(tl) > 0 THEN TRUE ELSE FALSE END FROM TeacherLesson tl WHERE tl.teacher.id = ?1 AND tl.lesson.number = ?2 AND tl.lesson.dayOfWeek = ?3 AND tl.lesson.denominator = ?4")
    Boolean teacherHasLessonAtThisTime(String teacherId, Integer lessonNumber,
        String dayOfWeek, boolean denominator);

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN TRUE ELSE FALSE END FROM Lesson l WHERE l.dayOfWeek = ?1 AND l.classroom.id = ?2 AND l.number = ?3")
    boolean existsByDayOfWeekAndClassroomId(String dayOfWeek,
        String classroomId, Integer lessonNumber);

    @Query("SELECT CASE WHEN COUNT(l) > 0 THEN TRUE ELSE FALSE END FROM Lesson l WHERE l.dayOfWeek = ?1 AND l.group.id = ?2 AND l.number = ?3")
    boolean existsByDayOfWeekGroupIdAndLessonNumber(String dayOfWeek,
        String groupId, Integer lessonNumber);

    @Query("SELECT l FROM Lesson l WHERE l.group.id = ?1 AND l.schedule.id = ?2")
    List<Lesson> findAllByGroupIdAndScheduleId(String groupId,
        String scheduleId);
}
