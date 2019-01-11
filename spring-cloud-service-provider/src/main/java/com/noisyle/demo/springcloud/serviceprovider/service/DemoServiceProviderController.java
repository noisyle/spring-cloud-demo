package com.noisyle.demo.springcloud.serviceprovider.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DemoServiceProviderController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${server.port}")
	private String port;
	
	@Value("${message.greeting}")
	private String greeting;
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greeting(@RequestParam String name) {
        logger.info("DemoServiceProviderController /greeting, param: {}", name);
		return String.format(greeting, name) + String.format(" (from port:%s)", port);
	}
}
