package com.conneqt.channelsubscriptions.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.conneqt.channelsubscriptions.model.Users;
import com.conneqt.channelsubscriptions.repository.UsersRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepository usersRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> userInfo=usersRepository.findUserByUserName(username);
		return userInfo.map(UserInfoUserDetails::new)
		.orElseThrow(()->new UsernameNotFoundException("user not found "+username));	
	}

}
