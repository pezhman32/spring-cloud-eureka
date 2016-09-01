package com.brogrammer.spring.cloud.eureka.customer;

import com.brogrammer.spring.cloud.eureka.dependecies.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@RestController
public class CustomerApplication {

	@Autowired
	StoreClient storeClient;

	@RequestMapping("/getStores")
	public List<Store> getStores() {
		return storeClient.getStores();
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(CustomerApplication.class).web(true).run(args);
	}

}
