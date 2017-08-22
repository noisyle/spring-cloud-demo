package com.noisyle.demo.springcloud.serviceconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoServiceConsumerController {

	@Autowired
    RestTemplate restTemplate;
	
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return restTemplate.getForEntity("http://DEMOSERVICEPROVIDER/hello?name={name}", String.class, name).getBody();
    }
}
