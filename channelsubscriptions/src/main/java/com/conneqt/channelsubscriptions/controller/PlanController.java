package com.conneqt.channelsubscriptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.channelsubscriptions.model.Plan;
import com.conneqt.channelsubscriptions.service.PlanService;

@RestController
public class PlanController {
	@Autowired
	private PlanService planService;

	@GetMapping("/api/public/getallplan")
	public ResponseEntity<List<Plan>> getAllPlan() {
		List<Plan> plans = planService.getAllPlan();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);

	}

	@PostMapping("/api/private/addPlan")
	@PreAuthorize("hasAuthority('ADMIN')"+"|| hasAuthority('OPERATOR')")
	public ResponseEntity<Plan> addPlan(@RequestBody Plan plan) {
		Plan pln = planService.addPlan(plan);
		return new ResponseEntity<Plan>(pln, HttpStatus.OK);
	}

}
