package com.uniteller.paymentprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PaymentProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentProcessApplication.class, args);
	}

	@GetMapping("/")
	public String hostWelcome(){
		return "<H1>Hello User</H1>";
	}

}
