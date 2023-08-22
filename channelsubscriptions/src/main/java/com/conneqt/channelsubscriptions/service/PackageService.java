package com.conneqt.channelsubscriptions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conneqt.channelsubscriptions.model.ChannelPackage;
import com.conneqt.channelsubscriptions.repository.PackageRepository;

@Service
public class PackageService {
	@Autowired
	PackageRepository packageRepository;

	public List<ChannelPackage> getAllPackage() {
		List<ChannelPackage> packages = packageRepository.findAll();
		return packages;
	}

	public ChannelPackage addPackage(ChannelPackage packag) {
		ChannelPackage savedpackage = packageRepository.save(packag);
		return savedpackage;
	}
}
