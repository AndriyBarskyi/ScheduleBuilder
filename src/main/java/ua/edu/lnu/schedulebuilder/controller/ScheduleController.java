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
import ua.edu.lnu.schedulebuilder.dto.ScheduleDTO;
import ua.edu.lnu.schedulebuilder.service.ScheduleService;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.getScheduleById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ScheduleDTO> addNewSchedule(
        @RequestBody @Validated ScheduleDTO newSchedule) {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.addNewSchedule(newSchedule));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable String id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(
        @RequestBody @Validated ScheduleDTO newSchedule,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.updateSchedule(newSchedule, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<ScheduleDTO>> getAllSchedulesByDepartmentId(
        @PathVariable String departmentId) {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.getAllSchedulesByDepartmentId(departmentId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/academic-year/{academicYearId}/department/{departmentId}/semester/{semester}")
    public ResponseEntity<ScheduleDTO> getScheduleByAcademicYearIdAndDepartmentIdAndSemester(
        @PathVariable String academicYearId,
        @PathVariable String departmentId,
        @PathVariable String semester) {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.getScheduleByAcademicYearIdAndDepartmentIdAndSemester(
                academicYearId, departmentId, semester));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
        return ResponseEntity.status(HttpStatus.OK).body(
            scheduleService.getAllSchedules());
    }
}
