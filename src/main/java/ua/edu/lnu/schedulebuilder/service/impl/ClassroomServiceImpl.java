package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.ClassroomMapper;
import ua.edu.lnu.schedulebuilder.repository.ClassroomRepository;
import ua.edu.lnu.schedulebuilder.service.ClassroomService;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private static final String CLASSROOM_NOT_FOUND_BY_ID = "Classroom not found by id: ";
    private final ClassroomRepository classroomRepository;
    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository,
        ClassroomMapper classroomMapper) {
        this.classroomRepository = classroomRepository;
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
        return classroomRepository.findById(id)
            .map(classroom -> {
                classroomMapper.updateClassroom(classroom, newClassroom);
                return classroomMapper.entityToDto(classroomRepository
                    .save(classroom));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public ClassroomDTO addNewClassroom(ClassroomDTO newClassroom) {
        return classroomMapper.entityToDto(
            classroomRepository.save(
                classroomMapper.dtoToEntity(newClassroom)
            )
        );
    }

    private void checkThatClassroomExists(String id) {
        if (!classroomRepository.existsById(id)) {
            throw new EntityNotExistsException(CLASSROOM_NOT_FOUND_BY_ID + id);
        }
    }
}
