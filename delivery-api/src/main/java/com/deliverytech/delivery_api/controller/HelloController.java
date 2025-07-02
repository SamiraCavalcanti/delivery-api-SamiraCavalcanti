package com.deliverytech.delivery_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController{
	
	@GetMapping("/")
	public String hello(){
		return "Olá mundo !";
	}
	
	@GetMapping("/api/status")
	public String status(){
		return "<h1>Aplicação voando</h1>";
	}
	
}