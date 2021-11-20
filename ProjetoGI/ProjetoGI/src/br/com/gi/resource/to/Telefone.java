package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Telefone {

	private Long id;
	private int ddd;
	private int numero;
	
	public Telefone(Long id, int ddd, int numero) {
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;	
	}
	
	public Telefone(int ddd, int numero) {
		this.ddd = ddd;
		this.numero = numero;
	}
	
	public Telefone() {
		
	}
	
	public Long getId() {
		return id;
	}
	
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", ddd=" + ddd + ", numero=" + numero + "]";
	}

}
