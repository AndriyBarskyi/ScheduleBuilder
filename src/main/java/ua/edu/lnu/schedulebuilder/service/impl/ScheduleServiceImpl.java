package ua.edu.lnu.schedulebuilder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.edu.lnu.schedulebuilder.dto.ScheduleDTO;
import ua.edu.lnu.schedulebuilder.exception.EntityNotExistsException;
import ua.edu.lnu.schedulebuilder.mapper.ScheduleMapper;
import ua.edu.lnu.schedulebuilder.model.AcademicYear;
import ua.edu.lnu.schedulebuilder.model.Schedule;
import ua.edu.lnu.schedulebuilder.repository.AcademicYearRepository;
import ua.edu.lnu.schedulebuilder.repository.DepartmentRepository;
import ua.edu.lnu.schedulebuilder.repository.ScheduleRepository;
import ua.edu.lnu.schedulebuilder.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    static final String LESSON_NOT_FOUND_BY_ID = "Schedule not found by id: ";
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;
    private final AcademicYearRepository academicYearRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository scheduleRepository,
        ScheduleMapper scheduleMapper,
        AcademicYearRepository academicYearRepository,
        DepartmentRepository departmentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleMapper = scheduleMapper;
        this.academicYearRepository = academicYearRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public ScheduleDTO getScheduleById(String id) {
        checkThatScheduleExists(id);
        return scheduleMapper.entityToDto(
            scheduleRepository.getReferenceById(id));
    }

    @Override
    public void deleteSchedule(String id) {
        checkThatScheduleExists(id);
        scheduleRepository.deleteById(id);
    }

    @Override
    public ScheduleDTO updateSchedule(ScheduleDTO newSchedule, String id) {
        checkThatScheduleExists(id);
        return scheduleRepository.findById(id)
            .map(schedule -> {
                scheduleMapper.updateSchedule(schedule, newSchedule);
                return scheduleMapper.entityToDto(scheduleRepository
                    .save(schedule));
            }).orElseThrow(EntityNotExistsException::new);
    }

    @Override
    public ScheduleDTO addNewSchedule(ScheduleDTO newSchedule) {
        return scheduleMapper.entityToDto(
            scheduleRepository.save(
                scheduleMapper.dtoToEntity(newSchedule)
            )
        );
    }

    @Override
    public ScheduleDTO getScheduleByAcademicYearIdAndDepartmentIdAndSemester(
        String academicYearId, String departmentId, String semester) {
        Schedule schedule =
            scheduleRepository.findByAcademicYearIdAndDepartmentIdAndSemester(
                academicYearId, departmentId, semester);
        if (schedule == null) {
            AcademicYear academicYear =
                academicYearRepository.getReferenceById(academicYearId);
            schedule = new Schedule();
            schedule.setAcademicYear(academicYear);
            schedule.setDepartment(
                departmentRepository.getReferenceById(departmentId));
            schedule.setSemester(Integer.parseInt(semester));
            schedule = scheduleRepository.save(schedule);
        }
        return scheduleMapper.entityToDto(schedule);
    }

    @Override
    public List<ScheduleDTO> getAllSchedulesByDepartmentId(
        String departmentId) {
        return scheduleMapper.entitiesToDtos(
            scheduleRepository.findAllByDepartmentId(departmentId));
    }

    @Override public List<ScheduleDTO> getAllSchedules() {
        return scheduleMapper.entitiesToDtos(scheduleRepository.findAll());
    }

    private void checkThatScheduleExists(String id) {
        if (!scheduleRepository.existsById(id)) {
            throw new EntityNotExistsException(LESSON_NOT_FOUND_BY_ID + id);
        }
    }
}
