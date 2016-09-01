package com.brogrammer.spring.cloud.eureka.customer;

import com.brogrammer.spring.cloud.eureka.dependecies.feignService.StoreFeign;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * An interface to connect to our StoreRest on client module
 *
 * @author Pezhman Jahanmard
 */
@FeignClient(value = "client1")
public interface StoreClient extends StoreFeign {
}
