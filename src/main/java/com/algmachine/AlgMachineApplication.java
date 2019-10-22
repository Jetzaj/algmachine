package com.algmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan({"com.algmachine.mapper"})
public class AlgMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgMachineApplication.class, args);
	}
}
