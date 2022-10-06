package com.sparta.hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing  //생성일자 수정일자 멤버 추가
@SpringBootApplication
public class HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(HwApplication.class, args);
	}

}
