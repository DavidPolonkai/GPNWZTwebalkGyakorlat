package com.Webalkalmaz.sTask.Gpnwzt.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/form").setViewName("form");
		registry.addViewController("/proceeded").setViewName("proceeded");
		registry.addViewController("/prodindex").setViewName("prodindex");
		registry.addViewController("/prodform").setViewName("prodform");
		registry.addViewController("/prodproceeded").setViewName("prodproceeded");

	}

}