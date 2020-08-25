package genpact.hackthon.interview.service;

import org.springframework.http.ResponseEntity;

import genpact.hackthon.interview.entity.Library;

public interface LibraryService {

	public ResponseEntity<?> add(Library library);

	public ResponseEntity<?> getAll();

	public ResponseEntity<?> get(Long id);

	public ResponseEntity<?> delete(Long id);

	public ResponseEntity<?> udpate(Library library);

}
