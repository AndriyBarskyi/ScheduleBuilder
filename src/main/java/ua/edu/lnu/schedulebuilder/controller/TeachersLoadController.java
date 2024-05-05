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
import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.service.TeachersLoadService;

@RestController
@RequestMapping("/api/v1/teachers-loads")
@RequiredArgsConstructor
public class TeachersLoadController {

    private final TeachersLoadService teachersLoadService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TeachersLoadDTO> getTeachersLoadById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.getTeachersLoadById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<TeachersLoadDTO> addNewTeachersLoad(
        @RequestBody @Validated TeachersLoadDTO newTeachersLoad) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.addNewTeachersLoad(newTeachersLoad));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachersLoad(@PathVariable String id) {
        teachersLoadService.deleteTeachersLoad(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TeachersLoadDTO> updateTeachersLoad(
        @RequestBody @Validated TeachersLoadDTO newTeachersLoad,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.updateTeachersLoad(newTeachersLoad, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/departments/{departmentId}/teachers/{teacherId}/academicYears/{academicYearId}")
    public ResponseEntity<List<TeachersLoadDTO>> getTeachersLoadsByDepartmentIdAndTeacherIdAndAcademicYearId(
        @PathVariable String departmentId,
        @PathVariable String teacherId,
        @PathVariable String academicYearId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.getTeachersLoadsByFacultyIdAndTeacherIdAndAcademicYearId(
                departmentId, teacherId, academicYearId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<TeachersLoadDTO>> getAllTeachersLoads() {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.getAllTeachersLoads());
    }
}
