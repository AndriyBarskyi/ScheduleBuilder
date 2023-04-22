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

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.service.ClassroomService;

@RestController
@RequestMapping("/api/v1/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDTO> getClassroomById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.getClassroomById(id));
    }

    @PostMapping
    public ResponseEntity<ClassroomDTO> addNewClassroom(
        @RequestBody @Validated ClassroomDTO newClassroom) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.addNewClassroom(newClassroom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDTO> updateFootballer(
        @RequestBody @Validated ClassroomDTO newClassroom,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            classroomService.updateClassroom(newClassroom, id));
    }
}
