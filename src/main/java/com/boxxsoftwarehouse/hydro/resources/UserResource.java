package com.boxxsoftwarehouse.hydro.resources;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boxxsoftwarehouse.hydro.services.WebScrappingService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	private WebScrappingService webScrappingService;

	@GetMapping
	public ResponseEntity<String> findAll() {
		Document document = this.webScrappingService.connect("https://google.com.br");
		return ResponseEntity.ok().body(document.title());
	}

}
