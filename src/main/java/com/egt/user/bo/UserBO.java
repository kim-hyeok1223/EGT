package com.egt.user.bo;

import java.util.List;

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
	public Integer addUser(String email, String password, String name, int height, int weight) {
		UserEntity userEntity = userRepository.save(
								UserEntity.builder()
								.email(email)
								.password(password)
								.name(name)
								.height(height)
								.weight(weight)
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
	
	// 닉넴 중복확인
	public UserEntity getUserEntityByName(String name) {
		return userRepository.findByName(name);
	}
	// 유저 모든 정보
	public List<UserEntity> getAllUserEntities() {
	    return userRepository.findAll();
	}
	// 유저 삭제
	public void deleteUserByUserId(int userId) {
		 userRepository.deleteById(userId);
	}
}
