package com.conneqt.channelsubscriptions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.conneqt.channelsubscriptions.model.Channel;
import com.conneqt.channelsubscriptions.repository.ChannelRepository;

@SpringBootTest
class ChannelServiceTest {

	/*
	 * @Test void testGetAllChannels() { fail("Not yet implemented"); }
	 * 
	 * @Test void testAddChannels() { fail("Not yet implemented"); }
	 */

	@Autowired
	private ChannelService channelService;
		
	@MockBean
	private ChannelRepository channelRepository;
	
	@BeforeEach
	void setup() {
		Optional<Channel> channel=Optional.of(new Channel(Long.valueOf(1),"India TV",Double.valueOf(50),"Hindi"));
		Mockito.when(channelRepository.findById(Long.valueOf(1))).thenReturn(channel);
		Channel channel1=new Channel("India TV",Double.valueOf(50),"Hindi");
		Mockito.when(channelRepository.save(channel1)).thenReturn(channel.get());
	}
	
	@Test
	void testGetChannelById() {
		String channel_Name="India TV";
		Channel channelById=channelService.getChannelById(Long.valueOf(1));
		assertEquals(channel_Name, channelById.getChannelName());
	}
	
	@Test
	void testaddChannels() {
		Channel channel=new Channel(Long.valueOf(1),"India TV",Double.valueOf(50),"Hindi");
		Channel channelById=channelService.addChannels(channel);
		assertNotNull(channelById.getChannelId());
	}

}
