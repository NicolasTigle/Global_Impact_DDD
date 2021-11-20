package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Endereco {
	
private Long   id;
private String cep;
private String estado;
private String cidade;
private String bairro;
private String rua;
private int    numero;
private String complemento;

public Endereco(Long id, String cep, String estado, String cidade, String bairro, String rua, int numero,
		String complemento) {
	this.id = id;
	this.cep = cep;
	this.estado = estado;
	this.cidade = cidade;
	this.bairro = bairro;
	this.rua = rua;
	this.numero = numero;
	this.complemento = complemento;

}

public Endereco(String cep, String estado, String cidade, String bairro, String rua, int numero,
		String complemento) {
	this.cep = cep;
	this.estado = estado;
	this.cidade = cidade;
	this.bairro = bairro;
	this.rua = rua;
	this.numero = numero;
	this.complemento = complemento;

}

public Endereco() {
	
}

public Long getId() {
	return id;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public String getRua() {
	return rua;
}

public void setRua(String rua) {
	this.rua = rua;
}

public int getNumero() {
	return numero;
}

public void setNumero(int numero) {
	this.numero = numero;
}

public String getComplemento() {
	return complemento;
}

public void setComplemento(String complemento) {
	this.complemento = complemento;
}

@Override
public String toString() {
	return "Endereco [id=" + id + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro
			+ ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
}



}
