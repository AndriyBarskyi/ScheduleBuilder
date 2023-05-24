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
import ua.edu.lnu.schedulebuilder.dto.FacultyDTO;
import ua.edu.lnu.schedulebuilder.service.FacultyService;

@RestController
@RequestMapping("/api/v1/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.getFacultyById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<FacultyDTO> addNewFaculty(
        @RequestBody @Validated FacultyDTO newFaculty) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.addNewFaculty(newFaculty));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FacultyDTO> updateFaculty(
        @RequestBody @Validated FacultyDTO newFaculty,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.updateFaculty(newFaculty, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<FacultyDTO>> getAllFaculties() {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.getAllFaculties());
    }
}
