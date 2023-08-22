package com.conneqt.channelsubscriptions.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.conneqt.channelsubscriptions.model.Channel;
import com.conneqt.channelsubscriptions.service.ChannelService;

@WebMvcTest(ChannelController.class)
class ChannelControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private ChannelService channelService;

	private Channel channel;

	@BeforeEach
	void setup() {
		channel = new Channel(Long.valueOf(1), "India TV", Double.valueOf(50), "Hindi");
	}

	@Test
	public void testAddStudent() throws Exception {
		Channel channelEntity = new Channel(Long.valueOf(1), "India TV", Double.valueOf(50), "Hindi");
		Mockito.when(channelService.addChannels(channelEntity)).thenReturn(channel);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/private/add").contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n" + "  \"channelId\": 1,\r\n" + "  \"channelName\": \"ETV Jharkhand\",\r\n"
						+ "  \"channelCost\": 50,\r\n" + "  \"channelLanguage\": \"Hindi\"\r\n" + "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
