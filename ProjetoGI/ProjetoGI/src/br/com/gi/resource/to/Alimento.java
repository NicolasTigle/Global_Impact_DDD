package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alimento {
	
	private Long id;
	private Long idSupermercado;
	private String nome;
	private String categoria;
	private int quantidade;
	private String dataValidade;
	private String tipo;
	
	public Alimento(Long id, Long idSupermercado, String nome, String categoria, int quantidade, String dataValidade, String tipo) {
		this.id = id;
		this.idSupermercado = idSupermercado;
		this.nome = nome;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
		this.tipo = tipo;
	}
	
	public Alimento(Long idSupermercado, String nome, String categoria, int quantidade, String dataValidade, String tipo) {
		this.idSupermercado = idSupermercado;
		this.nome = nome;
		this.categoria = categoria;
		this.quantidade = quantidade;
		this.dataValidade = dataValidade;
		this.tipo = tipo;
	}

	public Alimento() {
		
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdSupermercado() {
		return idSupermercado;
	}

	public void setIdSupermercado(Long idSupermercado) {
		this.idSupermercado = idSupermercado;
	}

	@Override
	public String toString() {
		return "Alimento [id=" + id + ", idSupermercado=" + idSupermercado + ", nome=" + nome + ", categoria="
				+ categoria + ", quantidade=" + quantidade + ", dataValidade=" + dataValidade + ", tipo=" + tipo + "] \n";
	}
	
}
