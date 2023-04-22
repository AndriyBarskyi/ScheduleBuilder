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

import ua.edu.lnu.schedulebuilder.dto.AcademicYearDTO;
import ua.edu.lnu.schedulebuilder.service.AcademicYearService;

@RestController
@RequestMapping("/api/v1/academicYears")
public class AcademicYearController {

    private final AcademicYearService academicYearService;

    @Autowired
    public AcademicYearController(AcademicYearService academicYearService) {
        this.academicYearService = academicYearService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> getAcademicYearById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.getAcademicYearById(id));
    }

    @PostMapping
    public ResponseEntity<AcademicYearDTO> addNewAcademicYear(
        @RequestBody @Validated AcademicYearDTO newAcademicYear) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.addNewAcademicYear(newAcademicYear));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYear(@PathVariable String id) {
        academicYearService.deleteAcademicYear(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> updateFootballer(
        @RequestBody @Validated AcademicYearDTO newAcademicYear,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.updateAcademicYear(newAcademicYear, id));
    }
}
