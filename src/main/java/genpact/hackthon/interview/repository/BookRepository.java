package genpact.hackthon.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genpact.hackthon.interview.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	@Modifying
	@Query("DELETE FROM Book b WHERE b.id = ?1")
	public void deleteById(Long id);
}
