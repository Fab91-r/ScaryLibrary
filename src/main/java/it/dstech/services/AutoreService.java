package it.dstech.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Autore;
import it.dstech.models.Libro;
import it.dstech.repositories.AutoreRepository;
import it.dstech.repositories.LibroRepository;

@Service
public class AutoreService {

	@Inject
	private AutoreRepository autoreRepository;
	@Inject
	private LibroService libroService;

	public List<Autore> getAllAutori() {
		return (List<Autore>) autoreRepository.findAll();
	}

	public void insertAutore(String nome, String dataDiNascita) {
		Autore nuovoAutore = new Autore();
		nuovoAutore.setNome(nome);
		nuovoAutore.setDataDiNascita(dataDiNascita);
		autoreRepository.save(nuovoAutore);
	}

	public Autore getAutorePerId(Long idAutore) {
		Autore autore = autoreRepository.findById(idAutore).get();
		return autore;
	}

	public void updateAutore(String nome, String dataDiNascita, Long idAutore) {
		Autore autoreModificato = getAutorePerId(idAutore);
		autoreModificato.setNome(nome);
		autoreModificato.setDataDiNascita(dataDiNascita);
		autoreRepository.save(autoreModificato);
	}

	public void deleteAutore(Long idAutore) {
		autoreRepository.deleteById(idAutore);
	}

	public List<Autore> getUndiciAutoriVecchi() {
		List<Autore> lista = autoreRepository.findTop11ByOrderByDataDiNascita();
		return lista;
	}

	public List<Entry<String, Integer>> getAutoriConPiuLibri() {

		HashMap<String, Integer> map = new HashMap<>();
		List<Autore> listaAutori = getAllAutori();
		for (Autore autore : listaAutori) {
			List<Libro> listaLibri = libroService.getLibriPerIdAutore(autore.getIdAutore());
			int count = listaLibri.size();
			map.put(autore.getNome(), count);
		}
		Stream<Map.Entry<String, Integer>> sorted = map.entrySet().stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).limit(10);
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());  
		list = sorted.collect(Collectors.toList());
        return list;
	}

	public Long getIdPerAutore(String nome)
	{
		Autore autore = autoreRepository.findByNome(nome);
		Long id = autore.getIdAutore();
		return id;
	}
}
