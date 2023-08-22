package com.conneqt.channelsubscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conneqt.channelsubscriptions.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}
