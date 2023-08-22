package com.conneqt.channelsubscriptions.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.conneqt.channelsubscriptions.model.Channel;
import com.conneqt.channelsubscriptions.model.ChannelPackage;
import com.conneqt.channelsubscriptions.model.Plan;
import com.conneqt.channelsubscriptions.model.Subscribe;
import com.conneqt.channelsubscriptions.model.SubscriptionCycle;
import com.conneqt.channelsubscriptions.model.Users;
import com.conneqt.channelsubscriptions.repository.PlanRepository;
import com.conneqt.channelsubscriptions.repository.SubscribeRepository;

class SubscribeServiceTest extends SubscribeService {

	@Autowired
	private SubscribeService subscribeService;
		
	@MockBean
	private SubscribeRepository subscribeRepository;
	@MockBean
	private PlanRepository planRepository;
	
	@BeforeEach
	void setup() {
		Optional<Subscribe> channel=Optional.of(new Subscribe(Long.valueOf(1),new Users(Long.valueOf(2402),"","","",null),new ChannelPackage(Long.valueOf(1),"",null),new Channel(Long.valueOf(1),"",0.0,""),new Plan(Long.valueOf(1),"",Long.valueOf(1)),new SubscriptionCycle(Long.valueOf(1),LocalDateTime.now(),LocalDateTime.now())));
		Mockito.when(subscribeRepository.findById(Long.valueOf(1))).thenReturn(channel);
	}

	@Test
	void testGetAllSubscribtionBasedOnUserId() {
		Long packageId=Long.valueOf(1);
		Optional<Subscribe> channelById=subscribeRepository.findById(Long.valueOf(1));
		assertEquals(packageId, channelById.get().getChannelPackages().getPackageId());
	}

}
