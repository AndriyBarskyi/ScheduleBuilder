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
import ua.edu.lnu.schedulebuilder.dto.PlanDTO;
import ua.edu.lnu.schedulebuilder.service.PlanService;

@RestController
@RequestMapping("/api/v1/plans")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> getPlanById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            planService.getPlanById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<PlanDTO> addNewPlan(
        @RequestBody @Validated PlanDTO newPlan) {
        return ResponseEntity.status(HttpStatus.OK).body(
            planService.addNewPlan(newPlan));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable String id) {
        planService.deletePlan(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PlanDTO> updatePlan(
        @RequestBody @Validated PlanDTO newPlan,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            planService.updatePlan(newPlan, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/departments/{departmentId}/academic-years/{academicYearId}")
    public ResponseEntity<List<PlanDTO>> getPlansByDepartmentIdAndAcademicYearId(
        @PathVariable String departmentId,
        @PathVariable String academicYearId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            planService.getPlansByDepartmentIdAndAcademicYearId(departmentId,
                academicYearId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<PlanDTO>> getAllPlans() {
        return ResponseEntity.status(HttpStatus.OK).body(
            planService.getAllPlans());
    }
}