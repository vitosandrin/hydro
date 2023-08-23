package com.boxxsoftwarehouse.hydro.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boxxsoftwarehouse.hydro.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User user = new User(1L, "viTO", "TUDO BEM", "senha", "phone", "is_validate");
		return ResponseEntity.ok().body(user);
	}

}
