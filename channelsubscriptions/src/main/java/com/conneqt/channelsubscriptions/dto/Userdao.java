package com.conneqt.channelsubscriptions.dto;

import java.util.Set;

import com.conneqt.channelsubscriptions.model.Role;

import lombok.Data;

@Data
public class Userdao {
	private Long userId;
	private String userName;
	private String password;
	private String email;
	private Set<Role> roles;
}
