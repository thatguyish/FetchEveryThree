package com.UpToDateCryotp.Top5Crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
public class Top5CryptoApplication {
	private static final Logger log = LoggerFactory.getLogger(Top5CryptoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Top5CryptoApplication.class, args);

	}
		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder){
			return builder.build();
		}

		@Scheduled(fixedRate = 3000)
		public void run() throws Exception{
			RestTemplate restTemplate = new RestTemplate();
			Data[] data = restTemplate.getForObject("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?market_code=nex", Data[].class);
			log.info(data[0].toString());

		}



}
