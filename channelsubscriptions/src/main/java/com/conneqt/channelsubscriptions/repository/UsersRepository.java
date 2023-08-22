package com.conneqt.channelsubscriptions.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.conneqt.channelsubscriptions.model.Users;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findUserByUserName(String username);

}
