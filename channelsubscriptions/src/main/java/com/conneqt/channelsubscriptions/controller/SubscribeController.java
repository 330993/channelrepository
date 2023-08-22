package com.conneqt.channelsubscriptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.channelsubscriptions.model.Subscribe;
import com.conneqt.channelsubscriptions.service.SubscribeService;

import lombok.extern.log4j.Log4j2;



@RestController
@Log4j2
public class SubscribeController {
	@Autowired
	SubscribeService subscribeService;

	@GetMapping("/api/private/getallsubscribe")
	@PreAuthorize("hasAuthority('ADMIN')" + "|| hasAuthority('OPERATOR')")
	public ResponseEntity<List<Subscribe>> getAllSubscribe() {
		List<Subscribe> subscribes = subscribeService.getAllSubscribe();
		log.info("SubscribeController -> subscription Data fetched succesfully");
		return new ResponseEntity<List<Subscribe>>(subscribes, HttpStatus.OK);
	}

	@GetMapping("/api/private/getallsubscribebasedonuserid")
	@PreAuthorize("hasAuthority('ADMIN')" + "|| hasAuthority('OPERATOR')" + "|| hasAuthority('USER')")
	public ResponseEntity<List<Subscribe>> getAllSubscribtionBasedOnUserId(@RequestParam Long userId) {
		List<Subscribe> subscribes = subscribeService.getAllSubscribtionBasedOnUserId(userId);
		log.info("SubscribeController -> Subscription Data fetched succesfully for userId :"+userId);
		return new ResponseEntity<List<Subscribe>>(subscribes, HttpStatus.OK);
	}

	@PostMapping("/api/private/addsubscribtion")
	@PreAuthorize("hasAuthority('USER')")
	public ResponseEntity<Subscribe> addSubscribtion(@RequestBody Subscribe subscribe) {
		Subscribe subscribes = subscribeService.addSubscribtion(subscribe);
		log.info("SubscribeController -> User "+subscribes.getUser().getUserId()+" have subscribed Subscription the subscription succesfully");
		return new ResponseEntity<Subscribe>(subscribes, HttpStatus.OK);
	}
}
