package it.dstech.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autore {
	@Id
	@GeneratedValue
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
	@Override
	public String toString() {
		return "nome: " + nome + ", dataDiNascita: " + dataDiNascita;
	}

	
}
