package genpact.hackthon.interview.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import genpact.hackthon.interview.entity.Library;
import genpact.hackthon.interview.service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	@Autowired
	private LibraryService service;
	
	@GetMapping()
	public ResponseEntity<?> getAll() {
		return service.getAll();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Library library) {
		return service.add(library);
	}

	@PutMapping
	public ResponseEntity<?> udpate(@Valid @RequestBody Library library) {
		return service.udpate(library);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}
