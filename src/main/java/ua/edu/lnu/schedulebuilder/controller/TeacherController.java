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
import ua.edu.lnu.schedulebuilder.dto.TeacherDTO;
import ua.edu.lnu.schedulebuilder.service.TeacherService;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherService.getTeacherById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<TeacherDTO> addNewTeacher(
        @RequestBody @Validated TeacherDTO newTeacher) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherService.addNewTeacher(newTeacher));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(
        @RequestBody @Validated TeacherDTO newTeacher,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherService.updateTeacher(newTeacher, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<List<TeacherDTO>> getAllTeachersByDepartmentId(
        @PathVariable String departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherService.getAllTeachersByDepartmentId(departmentId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherService.getAllTeachers());
    }
}
