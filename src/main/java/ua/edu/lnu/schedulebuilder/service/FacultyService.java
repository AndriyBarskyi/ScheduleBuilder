package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.FacultyDTO;

public interface FacultyService {

    FacultyDTO getFacultyById(String id);

    List<FacultyDTO> getAllFaculties();

    void deleteFaculty(String id);

    FacultyDTO updateFaculty(FacultyDTO newFaculty,
        String id);

    FacultyDTO addNewFaculty(FacultyDTO newFaculty);
}
