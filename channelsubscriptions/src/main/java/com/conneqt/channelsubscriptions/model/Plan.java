package com.conneqt.channelsubscriptions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANID_SEQ")
	private Long planId;
	private String planName;
	private Long duration;
}
