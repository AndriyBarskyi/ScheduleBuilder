package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.ClassroomMapper;
import ua.edu.lnu.schedulebuilder.repository.ClassroomRepository;
import ua.edu.lnu.schedulebuilder.repository.FacultyRepository;
import ua.edu.lnu.schedulebuilder.service.ClassroomService;

import static ua.edu.lnu.schedulebuilder.service.impl.FacultyServiceImpl.FACULTY_NOT_FOUND_BY_ID;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    static final String CLASSROOM_NOT_FOUND_BY_ID =
        "Classroom not found by id: ";
    private final ClassroomRepository classroomRepository;
    private final FacultyRepository facultyRepository;
    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository,
        ClassroomMapper classroomMapper,
        FacultyRepository facultyRepository) {
        this.classroomRepository = classroomRepository;
        this.facultyRepository = facultyRepository;
        this.classroomMapper = classroomMapper;
    }

    @Override
    public ClassroomDTO getClassroomById(String id) {
        checkThatClassroomExists(id);
        return classroomMapper.entityToDto(
            classroomRepository.getReferenceById(id));
    }

    @Override
    public void deleteClassroom(String id) {
        checkThatClassroomExists(id);
        classroomRepository.deleteById(id);
    }

    @Override
    public ClassroomDTO updateClassroom(ClassroomDTO newClassroom, String id) {
        checkThatClassroomExists(id);
        checkThatFacultyExists(newClassroom.getFacultyId());
        return classroomRepository.findById(id)
            .map(classroom -> {
                classroomMapper.updateClassroom(classroom, newClassroom);
                return classroomMapper.entityToDto(classroomRepository
                    .save(classroom));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public ClassroomDTO addNewClassroom(ClassroomDTO newClassroom) {
        checkThatFacultyExists(newClassroom.getFacultyId());
        return classroomMapper.entityToDto(
            classroomRepository.save(
                classroomMapper.dtoToEntity(newClassroom)
            )
        );
    }

    @Override
    public List<ClassroomDTO> getAllClassroomsByFacultyId(String facultyId) {
        checkThatFacultyExists(facultyId);
        return classroomMapper.entitiesToDtos(
            classroomRepository.findAllByFacultyId(facultyId));
    }

    private void checkThatClassroomExists(String id) {
        if (!classroomRepository.existsById(id)) {
            throw new EntityNotExistsException(CLASSROOM_NOT_FOUND_BY_ID + id);
        }
    }

    private void checkThatFacultyExists(String id) {
        if (!facultyRepository.existsById(id)) {
            throw new EntityNotExistsException(
                FACULTY_NOT_FOUND_BY_ID + id);
        }
    }
}
