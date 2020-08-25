package genpact.hackthon.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import genpact.hackthon.interview.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
	@Modifying
	@Query("DELETE FROM Library lb WHERE lb.id = ?1")
	public void deleteById(Long id);
}
