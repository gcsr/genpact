package genpact.hackthon.interview.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import genpact.hackthon.interview.entity.Book;
import genpact.hackthon.interview.entity.Library;
import genpact.hackthon.interview.repository.LibraryRepository;
import genpact.hackthon.interview.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	private static final Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Autowired
	private LibraryRepository repository;

	@Override
	public ResponseEntity<?> add(Library library) {
		Optional<Library> opt = Optional.empty();
		if (null != library.getId())
			opt = repository.findById(library.getId());
		if (opt.isPresent()) {
			logger.debug("Library Already Exist {} ", library.getId());
			Library libDB = opt.get();
			libDB.setName(library.getName());
			if (!CollectionUtils.isEmpty(library.getBooks()))
				addAll(libDB.getBooks(),library.getBooks());
			repository.save(libDB);
			logger.debug("Updating Already Exist {} ", libDB.getId());
			return new ResponseEntity<>(libDB, HttpStatus.CREATED);
		} else {
			library = repository.save(library);
			logger.debug("Saving Library {}", library.getId());
			return new ResponseEntity<>(library, HttpStatus.CREATED);

		}

	}

	public void addAll(List<Book> mainList, List<Book> childList) {
		childList.stream().forEach((child) -> {
			if (null != child.getId()) {
				int index = mainList.indexOf(child);
				if (index > -1) {
					Book temp = mainList.get(index);
					temp.setQuantity(temp.getQuantity() + child.getQuantity());
				}
			}else
				mainList.add(child);
		});

	}

	@Override
	public ResponseEntity<?> udpate(Library library) {
		Optional<Library> opt = Optional.empty();
		if (null != library.getId())
			opt = repository.findById(library.getId());
		if (opt.isPresent()) {
			Library libDB = opt.get();
			libDB.setName(library.getName());
			if (!CollectionUtils.isEmpty(library.getBooks()))
				addAll(libDB.getBooks(),library.getBooks());
			repository.save(libDB);
			logger.debug("Updating Already Exist {} ", libDB.getId());
			return new ResponseEntity<>(libDB, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
	}

	@Override
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> get(Long id) {
		Optional<Library> opt = repository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<?> delete(Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
