package ua.edu.lnu.schedulebuilder.controller;

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

import lombok.RequiredArgsConstructor;
import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.service.TeachersLoadService;

@RestController
@RequestMapping("/api/v1/teachers-loads")
@RequiredArgsConstructor
public class TeachersLoadController {

    private final TeachersLoadService teachersLoadService;

    @GetMapping("/{id}")
    public ResponseEntity<TeachersLoadDTO> getTeachersLoadById(
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.getTeachersLoadById(id));
    }

    @PostMapping
    public ResponseEntity<TeachersLoadDTO> addNewTeachersLoad(
        @RequestBody @Validated TeachersLoadDTO newTeachersLoad) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.addNewTeachersLoad(newTeachersLoad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachersLoad(@PathVariable String id) {
        teachersLoadService.deleteTeachersLoad(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachersLoadDTO> updateFootballer(
        @RequestBody @Validated TeachersLoadDTO newTeachersLoad,
        @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(
            teachersLoadService.updateTeachersLoad(newTeachersLoad, id));
    }
}
