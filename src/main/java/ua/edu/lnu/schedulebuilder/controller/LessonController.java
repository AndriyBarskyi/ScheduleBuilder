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
import ua.edu.lnu.schedulebuilder.dto.LessonDTO;
import ua.edu.lnu.schedulebuilder.service.LessonService;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLessonById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.getLessonById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<LessonDTO> addNewLesson(
        @RequestBody @Validated LessonDTO newLesson, String teacherId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.addNewLesson(newLesson, teacherId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LessonDTO> updateLesson(
        @RequestBody @Validated LessonDTO newLesson,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.updateLesson(newLesson, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/groups/{groupId}")
    public ResponseEntity<List<LessonDTO>> getAllLessonsByGroupId(
        @PathVariable String groupId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.getAllLessonsByGroupId(groupId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<LessonDTO>> getAllLessons() {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.getAllLessons());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/groups/{groupId}/schedule/{scheduleId}")
    public ResponseEntity<List<LessonDTO>> getAllLessonsByGroupIdAndScheduleId(
        @PathVariable String groupId, @PathVariable String scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            lessonService.getAllLessonsByGroupIdAndScheduleId(groupId, scheduleId));
    }
}
