package com.conneqt.channelsubscriptions.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.conneqt.channelsubscriptions.model.Channel;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChannelRepositoryTest {
	@Autowired
	ChannelRepository channelRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setup() {
		Channel channel=new Channel(Long.valueOf(1),"India TV",Double.valueOf(50),"Hindi");
		entityManager.detach(channel);;
	}
@Test
public void testFindById() {
	Channel channel=channelRepository.findById(Long.valueOf(1)).get();
	assertEquals("India TV", channel.getChannelName());
	
}

}
