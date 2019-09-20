package it.dstech.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Libro {
	@Id
	@GeneratedValue
	private Long idLibro;
	private Long idAutore;
	private String titolo;
	private String anno;
	private String autore;
	private Double prezzo;
	private Integer pagine;
	private Integer copieDisponibili;
	private Integer copiePrenotate;
	
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
	@Override
	public String toString() {
		return "titolo: " + titolo + ", anno: " + anno + ", autore: " + autore + ", prezzo: " + prezzo + ", pagine: "
				+ pagine + ", copieDisponibili: " + copieDisponibili + ", copiePrenotate: " + copiePrenotate;
	}
	
	


	
}
