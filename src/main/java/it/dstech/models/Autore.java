package it.dstech.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autore {
	@Id
	@GeneratedValue
	private Long idAutore;
	private String nome;
	private Date dataDiNascita;
	
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
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	@Override
	public String toString() {
		return "nome: " + nome + ", dataDiNascita: " + dataDiNascita;
	}

	
}
