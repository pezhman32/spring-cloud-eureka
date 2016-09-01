package com.brogrammer.spring.cloud.eureka.dependecies.entity;

/**
 * Store Entity, just a simple class to work as an entity
 *
 * @author Pezhman Jahanmard
 */
public class Store {
	private String name;
	private String address;

	public Store() {
	}

	public Store(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
