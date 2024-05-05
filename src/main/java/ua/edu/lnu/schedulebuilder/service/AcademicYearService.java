package ua.edu.lnu.schedulebuilder.service;

import java.util.List;

import ua.edu.lnu.schedulebuilder.dto.AcademicYearDTO;

public interface AcademicYearService {

    AcademicYearDTO getAcademicYearById(String id);

    void deleteAcademicYear(String id);

    AcademicYearDTO updateAcademicYear(AcademicYearDTO newAcademicYear,
        String id);

    AcademicYearDTO addNewAcademicYear(AcademicYearDTO newAcademicYear);

    List<AcademicYearDTO> getAllAcademicYears();
}
