package com.brogrammer.spring.cloud.eureka.client;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class ClientApplication {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/nextClient")
	public String eurekaClient() {
		InstanceInfo instance = eurekaClient.getNextServerFromEureka("Client1", false);
		return instance.getHomePageUrl();
	}

	/**
	 * Using spring's discovery client to return all client1s addresses.
	 * @return
	 */
	@RequestMapping("/discoverClients")
	public List<ServiceInstance> discoveryClient() {
		return discoveryClient.getInstances("Client1");
		/*String result = "";
		List<ServiceInstance> instances = discoveryClient.getInstances("Client1");
		if (instances != null) {
			for (ServiceInstance instance : instances) {
				result += ("".equals(result) ? "" : ", ") + instance.getUri();
			}
		}

		return result;*/
	}

	@RequestMapping("/")
	public String home() {
		return "Hello world";
	}

	public static void main(String[] args) {
		new SpringApplicationBuilder(ClientApplication.class).web(true).run(args);
	}

}
