package com.conneqt.channelsubscriptions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conneqt.channelsubscriptions.model.Subscribe;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface SubscribeRepository extends JpaRepository<Subscribe, Long>{
	
	@Query(value="SELECT * FROM SUBSCRIBE S WHERE S.USER_ID =:userId",nativeQuery=true)
	List<Subscribe> findAllSubscribtionBasedOnUserId(Long userId);

}
