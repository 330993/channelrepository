package com.conneqt.channelsubscriptions.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.conneqt.channelsubscriptions.model.Role;
import com.conneqt.channelsubscriptions.model.Users;
import com.conneqt.channelsubscriptions.repository.RoleRepository;
import com.conneqt.channelsubscriptions.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Users addUser(Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findByRoleName("USER");
		Set<Role> userRoles = new HashSet<>();
		userRoles.add(role);
		user.setRoles(userRoles);
		return userRepository.save(user);
	}

	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}

	public Users assignRoleToUser(Users user) {
		Optional<Users> usr=userRepository.findUserByUserName(user.getUserName());
		if(usr.isPresent()) {
			Users ur=usr.get();
			ur.setRoles(user.getRoles());
			return userRepository.save(ur);
		}else
			throw new UsernameNotFoundException("user not found "+user.getUserName());
	}

}
