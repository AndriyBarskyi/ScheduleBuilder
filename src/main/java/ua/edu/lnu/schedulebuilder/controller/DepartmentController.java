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
import ua.edu.lnu.schedulebuilder.dto.DepartmentDTO;
import ua.edu.lnu.schedulebuilder.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departmentService.getDepartmentById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<DepartmentDTO> addNewDepartment(
        @RequestBody @Validated DepartmentDTO newDepartment) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departmentService.addNewDepartment(newDepartment));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(
        @RequestBody @Validated DepartmentDTO newDepartment,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departmentService.updateDepartment(newDepartment, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/faculties/{id}")
    public ResponseEntity<Iterable<DepartmentDTO>> getDepartmentsByFacultyId(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            departmentService.getAllDepartmentsByFacultyId(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        return ResponseEntity.status(HttpStatus.OK).body(
            departmentService.getAllDepartments());
    }
}
