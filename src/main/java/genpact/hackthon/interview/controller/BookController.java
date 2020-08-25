package genpact.hackthon.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping
	public String hello() {
		return "hello";
	}
}
