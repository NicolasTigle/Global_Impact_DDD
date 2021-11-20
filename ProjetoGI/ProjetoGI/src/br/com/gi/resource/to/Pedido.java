package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pedido {
	
	private Long id;
	private String dataCriacao;
	private String status;
	
	public Pedido(Long id, String dataCriacao, String status) {
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.status = status;
	}
	
	public Pedido(String dataCriacao, String status) {
		this.dataCriacao = dataCriacao;
		this.status = status;
	}

	public Pedido() {
		
	}
	
	public Long getId() {
		return id;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
