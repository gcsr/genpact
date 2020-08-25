package genpact.hackthon.interview.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Library {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;

	@Valid
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "LIBRABY_BOOK", joinColumns = @JoinColumn(name = "LIBRARY_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "BOOK_ID", nullable = false, unique = true))
	private List<Book> books = new ArrayList<>();
}
