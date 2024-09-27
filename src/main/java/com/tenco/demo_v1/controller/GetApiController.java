package com.tenco.demo_v1.controller;

import java.util.Map;

import org.h2.engine.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetApiController {

	@GetMapping("/hello")
	public String hello() {
		// 메시지 컨버터가 동작
		// StringHttpMessageConverter 객체가 동작함
		return "say Hi";
	}

	// 쿼리 스트링 방식(@RequestParam)
	// 주소설계: http://localhost:8080/qs1?name=둘리

	@GetMapping("/qs1")
	public String qs1(@RequestParam(name = "name") String name) {
		return "name=" + name;
	}

	// 주소설계: http://localhost:8080/qs2?name=둘리&age=10
	@GetMapping("/qs2")
	public String qs2(@RequestParam(name = "name") String name,
			@RequestParam(name = "age", required = false, defaultValue = "1") Integer age) {
		return "name=" + name + "& age=" + age;
	}

	// 주소설계: http://localhost:8080/qs3?name=둘리&age=10
	@GetMapping("/qs3")
	public String qs3(@RequestParam Map<String, String> data) {
		// Map 방식으로 동적으로 데이터 바인딩하기
		StringBuffer sb = new StringBuffer();

		// entrySet()으로 Map의 각 Entry(Key, Value)를 순회
		data.entrySet().forEach(entry -> { // 올바른 타입으로 entry가 추론됩니다.
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n"); // 각 키-값을 결과 문자열로 추가
		});

		// StringBuffer를 String으로 반환
		return sb.toString(); // null을 반환하지 않도록 변경
	}

	@GetMapping("/qs4")
	public User qs4(User user) {
		return user;
	}

}
