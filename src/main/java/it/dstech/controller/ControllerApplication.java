package it.dstech.controller;

import java.io.Serializable;
import java.util.List;
import it.dstech.models.*;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import it.dstech.services.AutoreService;
import it.dstech.services.LibroService;

@Named
@ViewScoped
public class ControllerApplication implements Serializable {

	private static final long serialVersionUID = -4963716232725135768L;

	@Inject
	private LibroService libroService;
	
	@Inject
	private AutoreService autoreService;
	
	private List<Libro> listaLibri;
	
	public LibroService getLibroService() {
		return libroService;
	}

	public void setLibroService(LibroService libroService) {
		this.libroService = libroService;
	}

	public AutoreService getAutoreService() {
		return autoreService;
	}

	public void setAutoreService(AutoreService autoreService) {
		this.autoreService = autoreService;
	}

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	@PostConstruct
	public void init()
	{
		
	}
	

}
