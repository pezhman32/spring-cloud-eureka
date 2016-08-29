package com.brogrammer.spring.cloud.eureka;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaServer
@EnableDiscoveryClient
@RestController
public class ServerApplication {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * Finds next registered client
	 */
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

	public static void main(String[] args) {
		new SpringApplicationBuilder(ServerApplication.class).web(true).run(args);
	}
}
