package com.conneqt.channelsubscriptions.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class ChannelPackage {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="PACKAGEID_SEQ")
	private Long packageId;
	private String packageName;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "PACK_CHANNEL", joinColumns = { @JoinColumn(name = "PACKAGE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "CHANNEL_ID") })
	private List<Channel> Channel;
}
