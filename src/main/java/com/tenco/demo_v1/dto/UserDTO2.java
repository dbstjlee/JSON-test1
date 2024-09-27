package com.tenco.demo_v1.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserDTO2 {

	private String name;
	private Integer age;
	@JsonProperty("car_list")
	private List<CarDTO> carList;

	// 비 정적 내부 클래스(none-static inner classes)
	// -> 비 정적 내부 클래스는 외부 클래스의 인스턴스가 필요함.
	// OR 외부 클래스로 빼기
	// 스프링 부트 DTO 설계 시 내부 클래스는 static 내부 클래스로 만들자

	// 정적(static) 내부 클래스
	@Data
	@ToString
	@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
	static class CarDTO {
		private String name;
		@JsonProperty("car_number") // 카멜 형식으로 변환
		private String carNumber;
	}

}
