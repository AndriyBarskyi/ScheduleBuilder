package ua.edu.lnu.schedulebuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.edu.lnu.schedulebuilder.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, String> {
}
