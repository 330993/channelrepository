package com.conneqt.channelsubscriptions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.conneqt.channelsubscriptions.model.ChannelPackage;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PackageRepository extends JpaRepository<ChannelPackage, Long> {

}
