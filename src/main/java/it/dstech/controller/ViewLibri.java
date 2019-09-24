package it.dstech.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import it.dstech.models.Autore;
import it.dstech.models.Libro;
import it.dstech.services.AutoreService;
import it.dstech.services.LibroService;

@Named
@ViewScoped
public class ViewLibri implements Serializable {

	private static final long serialVersionUID = -3112553143765867071L;

	@Inject
	private LibroService libroService;
	@Inject
	private AutoreService autoreService;

	private List<Libro> listaLibri;
	private List<Autore> listaAutori;
	private Long idLibro;
	private Long idAutore;
	private String titolo;
	private String anno;
	private String autore;
	private Double prezzo;
	private Integer pagine;
	private Integer copieDisponibili;
	private Integer copiePrenotate;

	public LibroService getLibroService() {
		return libroService;
	}

	public void setLibroService(LibroService libroService) {
		this.libroService = libroService;
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public Long getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Integer getPagine() {
		return pagine;
	}

	public void setPagine(Integer pagine) {
		this.pagine = pagine;
	}

	public Integer getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(Integer copieDisponibili) {
		this.copieDisponibili = copieDisponibili;
	}

	public Integer getCopiePrenotate() {
		return copiePrenotate;
	}

	public void setCopiePrenotate(Integer copiePrenotate) {
		this.copiePrenotate = copiePrenotate;
	}

	public void setListaAutori(List<Autore> listaAutori) {
		this.listaAutori = listaAutori;
	}
	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	public List<Autore> getListaAutori() {
		return listaAutori;
	}

	@PostConstruct
	public void view() {
		this.setListaLibri(libroService.getAllLibri());
		this.setListaAutori(autoreService.getAllAutori());
	}

	public void insert() {
		idAutore = autoreService.getIdPerAutore(autore);
		pagine = libroService.getPagineRandom(titolo, autore);
		libroService.insertLibro(titolo, idAutore, anno, autore, prezzo, pagine, copieDisponibili);
	}


}
