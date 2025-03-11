package com.learn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.entity.User;
import com.learn.repository.UserRepository;

// 1 @Service: new를 해서 가지고 있음
@Service

// 2
public class UserService {
	private final UserRepository userRepository; // a: final로 들어갈 자리만 만들어 둔다
	// UserService라는 생성자에 맡김

	// 생성자
	public UserService(UserRepository userRepository) { // b: Spring이 넣어주면
		this.userRepository = userRepository; // c: dependency injection: Spring이 만든걸 들어갈 자리에 넣어 줌(JpaRepository를 사용했기
												// 때문에)
	}

	// 3. getAllUsers()
	public List<User> getAllUsers() { // a
		List<User> result = null; // b
		// "쉐프가 뭘 하라고 시킴"
		result = userRepository.findAll(); // c: 함수만 호출, 함수이름은 JpaRepository 상속 받음
		return result; // c
	}

	// 4. createUser()
	public User createUser(String name) { // a
		User result = null; // b
		result = userRepository.save(new User(name)); // d: save: 자동으로 insert, VO의 목적으로 생성자(직관적) 사용
		System.out.println("저장 PK : " + result.getId());
		return result; // c
	}

}
