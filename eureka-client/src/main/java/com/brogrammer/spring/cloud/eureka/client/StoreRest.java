package com.brogrammer.spring.cloud.eureka.client;

import com.brogrammer.spring.cloud.eureka.dependecies.entity.Store;
import com.brogrammer.spring.cloud.eureka.dependecies.feignService.StoreFeign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * REST controller to implement our shared interface. we need to redefine @requestMapping here as well
 *
 * @author Pezhman Jahanmard
 */
@RestController
public class StoreRest implements StoreFeign {

	@Value("${eureka.instance.instanceId}")
	private String applicationName;

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/stores")
	public List<Store> getStores() {
		return Arrays.asList(new Store("Pezhman's Store", applicationName));
	}
}
