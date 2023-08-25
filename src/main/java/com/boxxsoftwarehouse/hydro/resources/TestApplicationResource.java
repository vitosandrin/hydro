package com.boxxsoftwarehouse.hydro.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestApplicationResource {
	
	@GetMapping
	public String testMethod() {
		return "Application running successfylly / Method success!";
	}
}