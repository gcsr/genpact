package genpact.hackthon.interview.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import genpact.hackthon.interview.entity.Book;
import genpact.hackthon.interview.repository.BookRepository;
import genpact.hackthon.interview.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository repository;
	
	@Override
	public ResponseEntity<?> add(Book book) {
		Optional<Book> opt = Optional.empty();
		if( null != book.getId())
			opt = repository.findById(book.getId());
		if(opt.isPresent()) {
			Book bookDB = opt.get();
			bookDB.setQuantity(bookDB.getQuantity()+book.getQuantity());
			repository.save(bookDB);
			return new ResponseEntity<>(bookDB,HttpStatus.CREATED);
		}else {
			book = repository.save(book);
			return new ResponseEntity<>(book,HttpStatus.CREATED);
			
		}
		
	}
	
	@Override
	public ResponseEntity<?> udpate(Book book) {
		Optional<Book> opt = Optional.empty();
		if( null != book.getId())
			opt = repository.findById(book.getId());
		if(opt.isPresent()) {
			Book bookDB = opt.get();
			book.setName(bookDB.getName());
			bookDB.setQuantity(book.getQuantity());
			repository.save(bookDB);
			return new ResponseEntity<>(bookDB,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
	}
	@Override
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<?> get(Long id) {
		Optional<Book> opt = repository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<>(opt.get(),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	@Override
	public ResponseEntity<?> delete(Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	

}
