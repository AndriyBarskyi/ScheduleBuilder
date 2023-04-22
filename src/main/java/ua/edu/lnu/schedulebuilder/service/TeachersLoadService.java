package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.TeachersLoadDTO;

public interface TeachersLoadService {

    TeachersLoadDTO getTeachersLoadById(String id);

    void deleteTeachersLoad(String id);

    TeachersLoadDTO updateTeachersLoad(TeachersLoadDTO newTeachersLoad,
        String id);

    TeachersLoadDTO addNewTeachersLoad(TeachersLoadDTO newTeachersLoad);
}
