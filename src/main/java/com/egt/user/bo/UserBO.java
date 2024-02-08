package com.egt.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egt.user.entity.UserEntity;
import com.egt.user.repository.UserRepository;

@Service
public class UserBO {

	@Autowired
	private UserRepository userRepository;
	// 회원가입
	// 이멜, 비번, 닉넴 받아서
	public Integer addUser(String email, String password, String name) {
		UserEntity userEntity = userRepository.save(
								UserEntity.builder()
								.email(email)
								.password(password)
								.name(name)
								.build());
		
		return userEntity == null ? null : userEntity.getId();

	}
	// 로그인
	public UserEntity getUserEntityByEmailPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	//이멜 중복확인
	public UserEntity getUserEntityByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
