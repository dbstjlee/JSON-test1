package com.tenco.demo_v1.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo_v1.dto.UserDTO;


@RestController // IoC 대상 
@RequestMapping("/post")
public class PostApiController {

    // 주소 설계 
    // http://localhost:8080/post/demo1    METHOD - Post 
    // 테스트 데이터  - { "name" : "둘리", "age": 11 }
    // 이거는 header라서 test 시 테스트 데이터를 body에 json 형식으로 입력해줘야 함.
    @PostMapping("/demo1")
    // 사용자가 던진 데이터를 바이딩 처리 -> HTTP 메세지 바디 영역 
    public String demo1(@RequestBody Map<String, Object> reqData) {
        // POST --> 리소스 취득, 생성 --> DB 접근기술 --> 영구히 데이터를 저장 한다. 
        StringBuffer sb = new StringBuffer();
        reqData.entrySet().forEach( (entry) -> {
            sb.append(entry.getKey() + " = " + entry.getValue());
        });
        // 메세지 컨버터가 동작 (리턴 타입 String )
        return sb.toString();
    }
    
    @PostMapping("/demo2")
    public String demo2(@RequestBody UserDTO userDTO) {
        // POST -> 리소스 취득, 생성 -> DB 접근 기술 -> 영구히 데이터를 저장한다.
        String userName = userDTO.getName();
        System.out.println("userName: " + userName);
        String userAge = userDTO.getAge();
        String userPhoneNumber = userDTO.getPhoneNumber();

        return "User Name : " + userName + ", User Age : " + userAge + ", User PhoneNumber : " + userPhoneNumber;
    }

}
