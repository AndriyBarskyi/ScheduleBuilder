package ua.edu.lnu.schedulebuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import ua.edu.lnu.schedulebuilder.dto.FacultyDTO;
import ua.edu.lnu.schedulebuilder.service.FacultyService;

@RestController
@RequestMapping("/api/v1/facultys")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyDTO> getFacultyById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.getFacultyById(id));
    }

    @PostMapping
    public ResponseEntity<FacultyDTO> addNewFaculty(
        @RequestBody @Validated FacultyDTO newFaculty) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.addNewFaculty(newFaculty));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable String id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyDTO> updateFootballer(
        @RequestBody @Validated FacultyDTO newFaculty,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            facultyService.updateFaculty(newFaculty, id));
    }
}
