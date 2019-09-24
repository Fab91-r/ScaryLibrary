package it.dstech.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Libro;
import it.dstech.repositories.LibroRepository;

@Service
public class LibroService {
	@Inject
	private LibroRepository libroRepository;

	public List<Libro> getAllLibri() {
		return (List<Libro>) libroRepository.findAll();
	}

	public void insertLibro(String titolo, Long idAutore, String anno, String autore, Double prezzo, Integer pagine,
			Integer copieDisponibili) {
		Libro nuovoLibro = new Libro();
		nuovoLibro.setTitolo(titolo);
		nuovoLibro.setIdAutore(idAutore);
		nuovoLibro.setAnno(anno);
		nuovoLibro.setAutore(autore);
		nuovoLibro.setPrezzo(prezzo);
		nuovoLibro.setPagine(pagine);
		nuovoLibro.setCopieDisponibili(copieDisponibili);
		nuovoLibro.setCopiePrenotate(0);
		libroRepository.save(nuovoLibro);
	}

	public Libro getLibroPerTitolo(String titolo) {
		Libro libro = libroRepository.findByTitolo(titolo).get(0);
		return libro;

	}

	public Libro getLibroPerId(Long idLibro) {
		Libro libro = libroRepository.findById(idLibro).get();
		return libro;
	}

	public List<Libro> getLibriPerIdAutore(Long idAutore) {
		return libroRepository.findByIdAutore(idAutore);
	}

	public void updateLibro(String titolo, String anno, Long idAutore, String autore, Double prezzo, Integer pagine,
			Integer copieDisponibili, Long idLibro) {
		Libro libro = getLibroPerId(idLibro);
		libro.setTitolo(titolo);
		libro.setIdAutore(idAutore);
		libro.setAutore(autore);
		libro.setAnno(anno);
		libro.setPrezzo(prezzo);
		libro.setPagine(pagine);
		libro.setCopieDisponibili(copieDisponibili);
		libroRepository.save(libro);
	}

	public void deleteLibro(Long idLibro) {
		libroRepository.deleteById(idLibro);
	}

	public void deleteLibriPerIdAutore(Long idAutore) {
		List<Libro> lista = getLibriPerIdAutore(idAutore);
		libroRepository.deleteAll(lista);
	}

	public void updateLibriPerIdAutore(Long idAutore, String autore) {
		List<Libro> lista = getLibriPerIdAutore(idAutore);
		for (Libro libro : lista) {
			libro.setAutore(autore);
		}
	}

	public Integer getPagineRandom(String titolo, String autore) {
		String titoloSenzaSpazi = titolo.replace(" ", "");
		int lunghezzaTitolo = titoloSenzaSpazi.length();
		String regex = " ";
		String[] array = autore.split(regex);
		String autoreNomeSenzaSpazi = array[0];
		int lunghezzaAutore = autoreNomeSenzaSpazi.length();
		Random random = new Random();
		Integer pagineRandom = (random.nextInt(199) + 1) * lunghezzaTitolo
				+ (random.nextInt(199) + 1) * lunghezzaAutore;
		return pagineRandom;
	}

	public List<Libro> getDieciLibriCostosi() {
		List<Libro> lista = libroRepository.findTop10ByOrderByPrezzoDesc();
		return lista;
	}

	public List<Libro> getLibriPrenotabili() {
		List<Libro> listaLibri = getAllLibri();
		List<Libro> listaLibriPrenotabili = new ArrayList<>();
		for (Libro libro : listaLibri) {
			if (libro.getCopieDisponibili() > 0) {
				listaLibriPrenotabili.add(libro);
			}
		}
		return listaLibriPrenotabili;
	}

	public void prenotaLibro(Long id) {
		Libro libro = getLibroPerId(id);
		libro.setCopiePrenotate(libro.getCopiePrenotate() + 1);
		libro.setCopieDisponibili(libro.getCopieDisponibili() - 1);
	}
	
	public List<Libro> getLibriAnnullabili() {
		List<Libro> listaLibri = getAllLibri();
		List<Libro> listaLibriAnnullabili = new ArrayList<>();
		for (Libro libro : listaLibri) {
			if (libro.getCopiePrenotate() > 0) {
				listaLibriAnnullabili.add(libro);
			}
		}
		return listaLibriAnnullabili;
	}

	public void annullaLibro(Long id) {
		Libro libro = getLibroPerId(id);
		libro.setCopiePrenotate(libro.getCopiePrenotate() - 1);
		libro.setCopieDisponibili(libro.getCopieDisponibili() + 1);
	}

}
