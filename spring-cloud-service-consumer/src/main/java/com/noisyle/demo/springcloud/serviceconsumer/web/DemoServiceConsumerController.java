package com.noisyle.demo.springcloud.serviceconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noisyle.demo.springcloud.serviceconsumer.service.DemoServiceConsumerService;

@RestController
public class DemoServiceConsumerController {

	@Autowired
	DemoServiceConsumerService demoServiceConsumerService;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return demoServiceConsumerService.hello(name);
    }
}
