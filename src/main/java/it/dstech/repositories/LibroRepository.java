package it.dstech.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.models.Libro;

//@Repository
public interface LibroRepository extends CrudRepository<Libro, Long> {

	List<Libro> findByTitolo(String titolo);

	List<Libro> findByIdAutore(Long idAutore);

	List<Libro> findTop10ByOrderByPrezzoDesc();


}
