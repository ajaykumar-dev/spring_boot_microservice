package com.uniteller.payerdaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@RestController
@Configuration
@EnableFeignClients
public class PayerDailyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayerDailyApplication.class, args);
	}

	@GetMapping("/")
	public String hostWelcome(){
		return "<H1>Payer Daily Service</H1>";
	}

	@Bean(name ="TxServiceClient" )
	public WebClient webClient() {
		return WebClient.builder().baseUrl("PAYMENT-PROCESS/payment/").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

}
