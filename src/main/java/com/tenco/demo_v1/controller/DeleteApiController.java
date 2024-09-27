package com.tenco.demo_v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // IoC 대상
public class DeleteApiController {

	/*** DELETE 요청 처리 ***/
	// http://localhost:8080/delete/100?account=우리은행
	// 기억하기!! DELETE 는 body가 없음!!
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<?> delete(@PathVariable(name = "userId") String userId,
			 @RequestParam(name ="account") String account) {
		
		System.out.println("userId: " + userId);
		System.out.println("account: " + account);
		
		return ResponseEntity.status(200).body("정상 삭제되었습니다.");
	}
	
	
}
