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
import ua.edu.lnu.schedulebuilder.dto.AcademicYearDTO;
import ua.edu.lnu.schedulebuilder.service.AcademicYearService;

@RestController
@RequestMapping("/api/v1/academic-years")
@RequiredArgsConstructor
public class AcademicYearController {

    private final AcademicYearService academicYearService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> getAcademicYearById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.getAcademicYearById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<AcademicYearDTO> addNewAcademicYear(
        @RequestBody @Validated AcademicYearDTO newAcademicYear) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.addNewAcademicYear(newAcademicYear));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcademicYear(@PathVariable String id) {
        academicYearService.deleteAcademicYear(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AcademicYearDTO> updateAcademicYear(
        @RequestBody @Validated AcademicYearDTO newAcademicYear,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.updateAcademicYear(newAcademicYear, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<AcademicYearDTO>> getAllAcademicYears() {
        return ResponseEntity.status(HttpStatus.OK).body(
            academicYearService.getAllAcademicYears());
    }
}
