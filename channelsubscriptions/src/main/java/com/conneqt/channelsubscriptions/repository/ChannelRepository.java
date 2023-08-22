package com.conneqt.channelsubscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conneqt.channelsubscriptions.model.Channel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ChannelRepository extends JpaRepository<Channel, Long> {

}
