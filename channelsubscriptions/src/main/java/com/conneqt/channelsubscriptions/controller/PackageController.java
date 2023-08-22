package com.conneqt.channelsubscriptions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.conneqt.channelsubscriptions.model.ChannelPackage;
import com.conneqt.channelsubscriptions.service.PackageService;

@RestController
public class PackageController {
	@Autowired
	PackageService PackageService;

	@GetMapping("/api/public/getallpackage")
	public ResponseEntity<List<ChannelPackage>> getAllPackage() {
		List<ChannelPackage> channels = PackageService.getAllPackage();
		return new ResponseEntity<List<ChannelPackage>>(channels, HttpStatus.OK);
	}
	
	@PostMapping("/api/private/addpackage")
	@PreAuthorize("hasAuthority('ADMIN')"+"|| hasAuthority('OPERATOR')")
	public ResponseEntity<ChannelPackage> addPackage(@RequestBody ChannelPackage packag) {
		ChannelPackage channels = PackageService.addPackage(packag);
		return new ResponseEntity<ChannelPackage>(channels, HttpStatus.OK);
	}

}
