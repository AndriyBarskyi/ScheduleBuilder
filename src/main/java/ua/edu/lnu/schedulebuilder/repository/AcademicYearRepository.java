package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.AcademicYear;

public interface AcademicYearRepository
    extends JpaRepository<AcademicYear, String> {
}
