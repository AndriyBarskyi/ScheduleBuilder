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
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentDTO;
import ua.edu.lnu.schedulebuilder.dto.TeacherDepartmentSaveDTO;
import ua.edu.lnu.schedulebuilder.service.TeacherDepartmentService;

@RestController
@RequestMapping("/api/v1/teacher-departments")
@RequiredArgsConstructor
public class TeacherDepartmentController {

    private final TeacherDepartmentService teacherDepartmentService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDepartmentDTO> getTeacherDepartmentById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.getTeacherDepartmentById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<TeacherDepartmentSaveDTO> addNewTeacherDepartment(
        @RequestBody @Validated TeacherDepartmentSaveDTO newTeacherDepartment) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.addNewTeacherDepartment(
                newTeacherDepartment));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherDepartment(
        @PathVariable String id) {
        teacherDepartmentService.deleteTeacherDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TeacherDepartmentSaveDTO> updateTeacherDepartment(
        @RequestBody @Validated TeacherDepartmentSaveDTO newTeacherDepartment,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.updateTeacherDepartment(
                newTeacherDepartment, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<TeacherDepartmentDTO>> getAllTeacherDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.getAllTeacherDepartments());
    }
}
