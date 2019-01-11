package com.noisyle.demo.springcloud.serviceconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DemoServiceConsumerService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "greetingServiceFallback")
	public String greeting(@RequestParam String name) {
		return restTemplate.getForObject("http://DEMO-SERVICE-PROVIDER/greeting?name={name}", String.class, name);
	}

	public String greetingServiceFallback(String name) {
		return "Error! param: " + name;
	}
}
