package com.noisyle.demo.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.netflix.zuul.ZuulFilter;
import com.noisyle.demo.springcloud.zuul.filter.AccessFilter;

@EnableZuulProxy
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
	    SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public ZuulFilter accessFilter() {
		return new AccessFilter();
	}
}
