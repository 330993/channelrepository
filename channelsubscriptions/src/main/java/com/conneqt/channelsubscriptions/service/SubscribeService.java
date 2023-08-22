package com.conneqt.channelsubscriptions.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conneqt.channelsubscriptions.model.Plan;
import com.conneqt.channelsubscriptions.model.Subscribe;
import com.conneqt.channelsubscriptions.model.SubscriptionCycle;
import com.conneqt.channelsubscriptions.repository.PlanRepository;
import com.conneqt.channelsubscriptions.repository.SubscribeRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class SubscribeService {
	@Autowired
	SubscribeRepository subscribeRepository;
	@Autowired
	PlanRepository planRepository;

	public List<Subscribe> getAllSubscribe() {
		List<Subscribe> subscribes = subscribeRepository.findAll();
		return subscribes;
	}

	public Subscribe addSubscribtion(Subscribe subscribe) {
		SubscriptionCycle subscriptionCycle = new SubscriptionCycle();
		LocalDateTime now = LocalDateTime.now();
		subscriptionCycle.setStartDate(now);
		Optional<Plan> p = planRepository.findById(subscribe.getPlan().getPlanId());
		if (p.isPresent())
			subscriptionCycle.setEndDate(now.plusMonths(p.get().getDuration()));
		else
			throw new RuntimeException("Plan not found Exception");
		subscribe.setSubscriptionCycle(subscriptionCycle);
		Subscribe subscribes = subscribeRepository.save(subscribe);
		return subscribes;
	}

	public List<Subscribe> getAllSubscribtionBasedOnUserId(Long userId) {
		List<Subscribe> subscribes = subscribeRepository.findAllSubscribtionBasedOnUserId(userId);
		log.info("getAllSubscribtionBasedOnUserId()-> Get the subscription for userId :"+userId);
		return subscribes;
	}
}
