package com.conneqt.channelsubscriptions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conneqt.channelsubscriptions.model.Plan;
import com.conneqt.channelsubscriptions.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepository;
	
	public List<Plan> getAllPlan(){
		return planRepository.findAll();		
	}
	public Plan addPlan(Plan plan){
		return planRepository.save(plan);		
	}
}
