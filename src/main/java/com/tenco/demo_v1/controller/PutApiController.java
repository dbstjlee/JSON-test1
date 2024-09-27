package com.tenco.demo_v1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo_v1.dto.UserDTO2;


@RestController // IoC (싱글톤 패턴)
public class PutApiController {

	/*
	 * 주소 설계 
	 * http://localhost:8080/put/demo1/100
	 * 
	 * @return JSON
	 */	
	
	@PutMapping("/put/demo1/{id}")
	public UserDTO2 putMethodName(@PathVariable(name = "id") String id, 
			@RequestBody UserDTO2 dto) {
		
		System.out.println("id:" + id);
		System.out.println("userDTO:" + dto.toString());
		
		// 메시지 컨버터 동작(JSON이라서 뷰리졸버가 동작하지 않음) 
		// -> userDTO2 -> JSON 반환 해서  -> 클라이언트에 응답 처리
		
		return dto;
	}
	
//	@PutMapping("/put/demo1/{id}")
//	public UserDTO2 putMethodName(@PathVariable(name = "id") String id) {
//		
//		System.out.println("id:" + id);
//		
//		// 메시지 컨버터 동작(JSON이라서 뷰리졸버가 동작하지 않음) 
//		// -> userDTO2 -> JSON 반환 해서  -> 클라이언트에 응답 처리
//		
//		return null;
//	}
	
	
	
	
	
	
}
