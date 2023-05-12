package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.AcademicYearDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.AcademicYearMapper;
import ua.edu.lnu.schedulebuilder.repository.AcademicYearRepository;
import ua.edu.lnu.schedulebuilder.service.AcademicYearService;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {

    static final String ACADEMIC_YEAR_NOT_FOUND_BY_ID =
        "Academic year not found by id: ";
    private final AcademicYearRepository academicYearRepository;
    private final AcademicYearMapper academicYearMapper;

    @Autowired
    public AcademicYearServiceImpl(
        AcademicYearRepository academicYearRepository,
        AcademicYearMapper academicYearMapper) {
        this.academicYearRepository = academicYearRepository;
        this.academicYearMapper = academicYearMapper;
    }

    @Override
    public AcademicYearDTO getAcademicYearById(String id) {
        checkThatAcademicYearExists(id);
        return academicYearMapper.entityToDto(
            academicYearRepository.getReferenceById(id));
    }

    @Override
    public void deleteAcademicYear(String id) {
        checkThatAcademicYearExists(id);
        academicYearRepository.deleteById(id);
    }

    @Override
    public AcademicYearDTO updateAcademicYear(AcademicYearDTO newAcademicYear,
        String id) {
        checkThatAcademicYearExists(id);
        return academicYearRepository.findById(id)
            .map(academicYear -> {
                academicYearMapper.updateAcademicYear(academicYear,
                    newAcademicYear);
                return academicYearMapper.entityToDto(academicYearRepository
                    .save(academicYear));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public AcademicYearDTO addNewAcademicYear(AcademicYearDTO newAcademicYear) {
        return academicYearMapper.entityToDto(
            academicYearRepository.save(
                academicYearMapper.dtoToEntity(newAcademicYear)
            )
        );
    }

    private void checkThatAcademicYearExists(String id) {
        if (!academicYearRepository.existsById(id)) {
            throw new EntityNotExistsException(
                ACADEMIC_YEAR_NOT_FOUND_BY_ID + id);
        }
    }
}
