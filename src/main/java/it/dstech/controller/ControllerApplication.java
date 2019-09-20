package it.dstech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.dstech.models.Libro;
import it.dstech.services.AutoreService;
import it.dstech.services.LibroService;

@Controller
public class ControllerApplication {

	@Autowired
	AutoreService autoreService;
	@Autowired
	LibroService libroService;
	
	
//	Libro libro = libroService.getLibroPerTitolo(titolo);
//	
//	List <Libro> list = libroService.getLibri();
//    for(Libro libro : list)
//    {
//    	if(libro.getTitolo().equals(titolo))
//    	{
//    	Integer copieDisponibiliAggiornate = libro.getCopieDisponibili() + copieDisponibili;
//		libro.setCopieDisponibili(copieDisponibiliAggiornate);
//    	}
//    	else
//    	{
//    		libroService.insertLibro(titolo, anno, idAutore, prezzo, pagine, copieDisponibili);
//    	}
//    }

}
