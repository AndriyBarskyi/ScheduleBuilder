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
import ua.edu.lnu.schedulebuilder.dto.GroupDTO;
import ua.edu.lnu.schedulebuilder.service.GroupService;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroupById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.getGroupById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<GroupDTO> addNewGroup(
        @RequestBody @Validated GroupDTO newGroup) {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.addNewGroup(newGroup));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<GroupDTO> updateGroup(
        @RequestBody @Validated GroupDTO newGroup,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.updateGroup(newGroup, id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/departments/{departmentId}/academic-years/{academicYear}/studying-years/{studyingYear}")
    public ResponseEntity<List<GroupDTO>> getAllGroupsByDepartmentIdAndAcademicYearAndStudyingYear(
        @PathVariable String departmentId,
        @PathVariable Integer academicYear,
        @PathVariable Integer studyingYear) {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.getAllGroupsByDepartmentIdAndAcademicYearAndStudyingYear(
                departmentId, academicYear, studyingYear));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/departments/{departmentId}/academic-years/{academicYear}")
    public ResponseEntity<List<GroupDTO>> getAllGroupsByDepartmentIdAndAcademicYear(
        @PathVariable String departmentId,
        @PathVariable Integer academicYear) {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.getAllGroupsByDepartmentIdAndAcademicYear(
                departmentId, academicYear));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return ResponseEntity.status(HttpStatus.OK).body(
            groupService.getAllGroups());
    }
}
