package it.dstech.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Autore;
import it.dstech.repositories.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public List<Autore> getAllAutori()
	{
		return (List<Autore>)autoreRepository.findAll();
	}
	
	public void insertAutore (String nome, Date dataDiNascita)
	{
		Autore nuovoAutore = new Autore();
		nuovoAutore.setNome(nome);
		nuovoAutore.setDataDiNascita(dataDiNascita);
		autoreRepository.save(nuovoAutore);
	}
	
	public Autore getAutorePerId(Long idAutore)
	{
		Autore autore = autoreRepository.findById(idAutore).get();
		return autore;
	}
	
	public void updateAutore(String nome, Date dataDiNascita, Long idAutore)
	{
		Autore autoreModificato = getAutorePerId(idAutore);
		autoreModificato.setNome(nome);
		autoreModificato.setDataDiNascita(dataDiNascita);
		autoreRepository.save(autoreModificato);
	}
	
	public void deleteAutore(Long idAutore)
	{
		autoreRepository.deleteById(idAutore);
	}
}
