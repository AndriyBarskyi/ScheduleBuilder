package ua.edu.lnu.schedulebuilder.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import ua.edu.lnu.schedulebuilder.service.TeacherDepartmentService;

@RestController
@RequestMapping("/api/v1/teacher-departments")
@RequiredArgsConstructor
public class TeacherDepartmentController {

    private final TeacherDepartmentService teacherDepartmentService;

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDepartmentDTO> getTeacherDepartmentById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.getTeacherDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<TeacherDepartmentDTO> addNewTeacherDepartment(
        @RequestBody @Validated TeacherDepartmentDTO newTeacherDepartment) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.addNewTeacherDepartment(
                newTeacherDepartment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacherDepartment(
        @PathVariable String id) {
        teacherDepartmentService.deleteTeacherDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDepartmentDTO> updateFootballer(
        @RequestBody @Validated TeacherDepartmentDTO newTeacherDepartment,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teacherDepartmentService.updateTeacherDepartment(
                newTeacherDepartment, id));
    }
}
