package com.noisyle.demo.springcloud.serviceconsumer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noisyle.demo.springcloud.serviceconsumer.service.DemoServiceConsumerService;

@RestController
public class DemoServiceConsumerController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DemoServiceConsumerService demoServiceConsumerService;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
    	logger.info("DemoServiceConsumerController /hello, param: {}", name);
        return demoServiceConsumerService.hello(name);
    }
}
