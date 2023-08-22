package com.conneqt.channelsubscriptions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHANNELID_SEQ")
	private Long channelId;
	private String channelName;
	private Double channelCost;
	private String channelLanguage;
	public Channel(String channelName, Double channelCost, String channelLanguage) {
		super();
		this.channelName = channelName;
		this.channelCost = channelCost;
		this.channelLanguage = channelLanguage;
	}
}
