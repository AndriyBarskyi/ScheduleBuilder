package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.TeachersLoad;

public interface TeachersLoadRepository
    extends JpaRepository<TeachersLoad, String> {
}
