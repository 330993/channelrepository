package com.conneqt.channelsubscriptions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conneqt.channelsubscriptions.model.Channel;
import com.conneqt.channelsubscriptions.repository.ChannelRepository;

@Service
public class ChannelService {
	@Autowired
	ChannelRepository channelRepository;

	public List<Channel> getAllChannels() {
		return channelRepository.findAll();
	}

	public Channel addChannels(Channel channel) {
		return channelRepository.save(channel);
	}

	public Channel getChannelById(Long channelId) {
		Optional<Channel> channel=channelRepository.findById(channelId);
		if(channel.isPresent())
			return channel.get();
		else
			return null;
	}

}
