package ua.edu.lnu.schedulebuilder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.TeachersLoadMapper;
import ua.edu.lnu.schedulebuilder.repository.TeachersLoadRepository;
import ua.edu.lnu.schedulebuilder.service.TeachersLoadService;

@Service
public class TeachersLoadServiceImpl implements TeachersLoadService {

    private static final String TEACHERS_LOAD_NOT_FOUND_BY_ID = "TeachersLoad not found by id: ";
    private final TeachersLoadRepository teachersLoadRepository;
    private final TeachersLoadMapper teachersLoadMapper;

    @Autowired
    public TeachersLoadServiceImpl(TeachersLoadRepository teachersLoadRepository,
        TeachersLoadMapper teachersLoadMapper) {
        this.teachersLoadRepository = teachersLoadRepository;
        this.teachersLoadMapper = teachersLoadMapper;
    }

    @Override
    public TeachersLoadDTO getTeachersLoadById(String id) {
        checkThatTeachersLoadExists(id);
        return teachersLoadMapper.entityToDto(
            teachersLoadRepository.getReferenceById(id));
    }

    @Override
    public void deleteTeachersLoad(String id) {
        checkThatTeachersLoadExists(id);
        teachersLoadRepository.deleteById(id);
    }

    @Override
    public TeachersLoadDTO updateTeachersLoad(TeachersLoadDTO newTeachersLoad, String id) {
        checkThatTeachersLoadExists(id);
        return teachersLoadRepository.findById(id)
            .map(teachersLoad -> {
                teachersLoadMapper.updateTeachersLoad(teachersLoad, newTeachersLoad);
                return teachersLoadMapper.entityToDto(teachersLoadRepository
                    .save(teachersLoad));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public TeachersLoadDTO addNewTeachersLoad(TeachersLoadDTO newTeachersLoad) {
        return teachersLoadMapper.entityToDto(
            teachersLoadRepository.save(
                teachersLoadMapper.dtoToEntity(newTeachersLoad)
            )
        );
    }

    private void checkThatTeachersLoadExists(String id) {
        if (!teachersLoadRepository.existsById(id)) {
            throw new EntityNotExistsException(TEACHERS_LOAD_NOT_FOUND_BY_ID + id);
        }
    }
}
