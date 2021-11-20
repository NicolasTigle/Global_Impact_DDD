package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Empresa {

	private Long id;
	private Endereco endereco;
	private String nome;
	private String email;
	private Long cnpj;
	private String senha;
	private Telefone telefone;
	
	

	public Empresa(Long id, String nome, String email, Long cnpj, String senha, Endereco endereco, 
			Telefone telefone) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Empresa(String nome, String email, Long cnpj, String senha, Endereco endereco, 
			Telefone telefone) {
		this.nome = nome;
		this.email = email;
		this.cnpj = cnpj;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public Empresa() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
}
