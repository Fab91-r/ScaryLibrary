package it.dstech.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.dstech.models.Autore;

//@Repository
public interface AutoreRepository extends CrudRepository<Autore, Long> {

	List<Autore> findTop11ByOrderByDataDiNascita();

	

}
