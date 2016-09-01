package com.brogrammer.spring.cloud.eureka.dependecies.feignService;

import com.brogrammer.spring.cloud.eureka.dependecies.entity.Store;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Shared between client and customer module.
 * However in client REST controller we need to redefine its @RequestMapping annotation because spring mvc cannot read it.
 *
 * @author Pezhman Jahanmard
 */
public interface StoreFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    List<Store> getStores();

//    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//    Store update(@PathVariable("storeId") Long storeId, Store store);
}