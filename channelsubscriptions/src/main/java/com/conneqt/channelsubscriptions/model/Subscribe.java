package com.conneqt.channelsubscriptions.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Subscribe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUBSCRIBERID_SEQ")
	private Long subscribeId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "userId")
	private Users user;
	@OneToOne(targetEntity = ChannelPackage.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "packageId")
	private ChannelPackage channelPackages;
	@OneToOne(targetEntity = Channel.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "addonChannelId")
	private Channel addonChannel;
	@ManyToOne(targetEntity = Plan.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "planId")
	private Plan plan;
	@OneToOne(targetEntity = SubscriptionCycle.class, fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "subCycleId")
	private SubscriptionCycle subscriptionCycle;
}
