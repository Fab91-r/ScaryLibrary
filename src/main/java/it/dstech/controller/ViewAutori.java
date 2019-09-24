package it.dstech.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import it.dstech.models.Autore;
import it.dstech.models.Libro;
import it.dstech.services.AutoreService;

@Named
@ViewScoped
public class ViewAutori implements Serializable {

	private static final long serialVersionUID = -3112553143765867071L;

	@Inject
	private AutoreService autoreService;
	private List<Libro> listaLibri;
	private List<Autore> listaAutori; 
	private Long idAutore;
	private String nome;
	private String dataDiNascita;
	

	public Long getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Long idAutore) {
		this.idAutore = idAutore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
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

	public void setListaAutori(List<Autore> listaAutori) {
		this.listaAutori = listaAutori;
	}

	@PostConstruct
	public void view()
	{
		this.setListaAutori(autoreService.getAllAutori());	
	}
	
	public void insert()
	{
		autoreService.insertAutore(nome, dataDiNascita);
	}
}
