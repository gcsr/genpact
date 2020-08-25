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

import genpact.hackthon.interview.entity.Book;
import genpact.hackthon.interview.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping()
	public ResponseEntity<?> getAll() {
		return service.getAll();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		return service.get(id);
	}

	@PostMapping
	public ResponseEntity<?> add(@Valid @RequestBody Book book) {
		return service.add(book);
	}

	@PutMapping
	public ResponseEntity<?> udpate(@Valid @RequestBody Book book) {
		return service.udpate(book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		return service.delete(id);
	}
}
