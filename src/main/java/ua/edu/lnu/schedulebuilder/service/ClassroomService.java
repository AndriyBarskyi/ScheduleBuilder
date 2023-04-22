package ua.edu.lnu.schedulebuilder.service;

import ua.edu.lnu.schedulebuilder.dto.ClassroomDTO;

public interface ClassroomService {

    ClassroomDTO getClassroomById(String id);

    void deleteClassroom(String id);

    ClassroomDTO updateClassroom(ClassroomDTO newClassroom,
        String id);

    ClassroomDTO addNewClassroom(ClassroomDTO newClassroom);
}
