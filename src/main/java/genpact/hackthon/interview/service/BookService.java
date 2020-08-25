package genpact.hackthon.interview.service;

import org.springframework.http.ResponseEntity;

import genpact.hackthon.interview.entity.Book;

public interface BookService {

	public ResponseEntity<?> add(Book book);

	public ResponseEntity<?> getAll();

	public ResponseEntity<?> get(Long id);

	public ResponseEntity<?> delete(Long id);

	public ResponseEntity<?> udpate(Book book);

}
