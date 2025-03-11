package com.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// 1
@Entity

// 2
@Table(name = "users") // 테이블 이름이 users, 원칙은 class명과 동일하지만, class User와 부딪혀서 이름 변경

// 3
public class User {
	@Id // c: PK로 사용
	@GeneratedValue(strategy = GenerationType.IDENTITY) // d. IDENTITY: 숫자형 while UUID는 String
	private Long id; // Long: 객체(heap memory, 느리지만 공간은 넓음), 안정적, generic 사용을 위해 VS long: 처리는 빠르지만 stack memory 공간은 작음 // a
	private String name; // b

	// 6. 기본 생성자: VO의 getter, setter 호출 목적, class를 객체로 변경할 때, 수동으로 생성, Spring(Jpa)에서 필요
	public User() {
	}

	// 7. 생성자: 초기화, 생성값 전달 목적(기능)
	public User(String name) {
		this.name = name;
	}

	// 4. getter/setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 5. toString
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
