package ua.edu.lnu.schedulebuilder.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherLessonSaveDTO;
import ua.edu.lnu.schedulebuilder.service.TeacherLessonService;

@RestController
@RequestMapping("/api/v1/teacher-lessons")
@RequiredArgsConstructor
public class TeacherLessonController {

    private final TeacherLessonService teacherLessonService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TeacherLessonDTO> getTeacherLessonById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherLessonService.getTeacherLessonById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<TeacherLessonSaveDTO> addNewTeacherLesson(
        @RequestBody @Validated TeacherLessonSaveDTO newTeacherLesson) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherLessonService.addNewTeacherLesson(
                newTeacherLesson));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherLesson(
        @PathVariable String id) {
        teacherLessonService.deleteTeacherLesson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TeacherLessonSaveDTO> updateTeacherLesson(
        @RequestBody @Validated TeacherLessonSaveDTO newTeacherLesson,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherLessonService.updateTeacherLesson(
                newTeacherLesson, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<TeacherLessonDTO>> getAllTeacherLessons() {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherLessonService.getAllTeacherLessons());
    }
}
