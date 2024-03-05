package com.egt.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.egt.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public UserEntity findByEmailAndPassword(String email, String password);
	
	public UserEntity findByEmail(String email);
	
	public UserEntity findByName(String name);
	
	public List<UserEntity> findAll();

	public void deleteById(int userId);
}
