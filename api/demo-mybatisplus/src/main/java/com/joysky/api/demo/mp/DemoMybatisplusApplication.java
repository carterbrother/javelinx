package com.joysky.api.demo.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.joysky.api.demo.mp.mapper"})
public class DemoMybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoMybatisplusApplication.class, args);
	}

}
