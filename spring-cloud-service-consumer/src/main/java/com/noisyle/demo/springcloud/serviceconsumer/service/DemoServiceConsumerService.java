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

	@HystrixCommand(fallbackMethod = "helloServiceFallback")
	public String hello(@RequestParam String name) {
		return restTemplate.getForObject("http://DEMO-SERVICE-PROVIDER/hello?name={name}", String.class, name);
	}

	public String helloServiceFallback(String name) {
		return "Error! param: " + name;
	}
}
