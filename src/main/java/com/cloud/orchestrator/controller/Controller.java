package com.cloud.orchestrator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name="app")
public class Controller {
	@Autowired
	RestTemplate restTemplate;
	@GetMapping(value="/hiorchestrator")
	public String getResponse() {
		return restTemplate.getForObject("http://app/hello", String.class);
	}

}
