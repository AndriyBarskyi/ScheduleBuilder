package ua.edu.lnu.schedulebuilder.controller;

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
import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.service.ClassroomService;

@RestController
@RequestMapping("/api/v1/classrooms")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDTO> getClassroomById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.getClassroomById(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<ClassroomDTO> addNewClassroom(
        @RequestBody @Validated ClassroomDTO newClassroom) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.addNewClassroom(newClassroom));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDTO> updateClassroom(
        @RequestBody @Validated ClassroomDTO newClassroom,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.updateClassroom(newClassroom, id));
    }
}
