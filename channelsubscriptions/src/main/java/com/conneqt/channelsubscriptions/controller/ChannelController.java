package com.conneqt.channelsubscriptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.channelsubscriptions.model.Channel;
import com.conneqt.channelsubscriptions.service.ChannelService;

@RestController
public class ChannelController {
	@Autowired
	ChannelService channelService;
	@GetMapping("/api/public/getallchannel")
	public List<Channel> getAllChannel(){
		List<Channel> channels=channelService.getAllChannels();
		return channels;
	}
	
	@PostMapping("/api/private/addchannel")
	@PreAuthorize("hasAuthority('ADMIN')")
	public Channel addChannel(@RequestBody Channel channel){
		Channel channels=channelService.addChannels(channel);
		return channels;
	}
}
