package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Supermercado extends Empresa {

	private String horarioFuncionamento;

	public Supermercado(Long id, String nome, String email, Long cnpj, String senha,
	String horarioFuncionamento, Endereco endereco, Telefone telefone) {
		super(id, nome, email, cnpj, senha, endereco, telefone);
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
	public Supermercado(String nome, String email, Long cnpj, String senha,
	String horarioFuncionamento, Endereco endereco, Telefone telefone) {
				super(nome, email, cnpj, senha, endereco, telefone);
				this.horarioFuncionamento = horarioFuncionamento;
	}
	
	public Supermercado() {
		
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}

	@Override
	public String toString() {
		return "EntidadeAssistencial [id=" + getId() + ", nome=" + getNome() + ", email=" + getEmail() + ", cnpj=" + getCnpj()
				+ ", senha=" + getSenha() + ", horarioFuncionamento=" + horarioFuncionamento +  ", "
						+ getEndereco() + ", " + getTelefone() + "] \n";
	}
	
}
