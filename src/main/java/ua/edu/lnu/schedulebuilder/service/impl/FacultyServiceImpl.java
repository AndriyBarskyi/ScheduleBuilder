package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.FacultyDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.FacultyMapper;
import ua.edu.lnu.schedulebuilder.repository.FacultyRepository;
import ua.edu.lnu.schedulebuilder.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

    static final String FACULTY_NOT_FOUND_BY_ID = "Faculty not found by id: ";
    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    @Autowired
    public FacultyServiceImpl(FacultyRepository facultyRepository,
        FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    @Override
    public FacultyDTO getFacultyById(String id) {
        checkThatFacultyExists(id);
        return facultyMapper.entityToDto(
            facultyRepository.getReferenceById(id));
    }

    @Override
    public void deleteFaculty(String id) {
        checkThatFacultyExists(id);
        facultyRepository.deleteById(id);
    }

    @Override
    public FacultyDTO updateFaculty(FacultyDTO newFaculty, String id) {
        checkThatFacultyExists(id);
        return facultyRepository.findById(id)
            .map(faculty -> {
                facultyMapper.updateFaculty(faculty, newFaculty);
                return facultyMapper.entityToDto(facultyRepository
                    .save(faculty));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public FacultyDTO addNewFaculty(FacultyDTO newFaculty) {
        return facultyMapper.entityToDto(
            facultyRepository.save(
                facultyMapper.dtoToEntity(newFaculty)
            )
        );
    }

    private void checkThatFacultyExists(String id) {
        if (!facultyRepository.existsById(id)) {
            throw new EntityNotExistsException(FACULTY_NOT_FOUND_BY_ID + id);
        }
    }
}
