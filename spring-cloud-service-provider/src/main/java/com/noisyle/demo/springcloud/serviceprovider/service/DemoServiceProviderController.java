package com.noisyle.demo.springcloud.serviceprovider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DemoServiceProviderController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${welcome}")
	private String welcome;
	
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		ServiceInstance instance = client.getLocalServiceInstance();
		logger.info("/hello, host:{}, service_id:{}, param:{}", instance.getHost(), instance.getServiceId(), name);
		return String.format(welcome, name);
	}
}
