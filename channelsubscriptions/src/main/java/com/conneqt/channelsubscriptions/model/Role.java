package com.conneqt.channelsubscriptions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLEID_SEQ")
	private Long roleId;
	private String roleName;

}
