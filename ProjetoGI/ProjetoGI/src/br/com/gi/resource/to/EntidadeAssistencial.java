package br.com.gi.resource.to;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EntidadeAssistencial extends Empresa {
	
	private int qtdBeneficiados;
	
	
	public EntidadeAssistencial(Long id,
			String nome,
			String email,
			Long cnpj,
			String senha,
			int qtdBeneficiados,
			Endereco endereco,
			Telefone telefone) {
		super(id, nome, email, cnpj, senha, endereco, telefone);
		this.qtdBeneficiados = qtdBeneficiados;
	}
	
	public EntidadeAssistencial(
			String nome,
			String email,
			Long cnpj,
			String senha,
			int qtdBeneficiados,
			Endereco endereco,
			Telefone telefone) {
		super(nome, email, cnpj, senha, endereco, telefone);
		this.qtdBeneficiados = qtdBeneficiados;
	}

	public EntidadeAssistencial() {
		
	}
	

	public int getQtdBeneficiados() {
		return qtdBeneficiados;
	}


	public void setQtdBeneficiados(int qtdBeneficiados) {
		this.qtdBeneficiados = qtdBeneficiados;
	}

	@Override
	public String toString() {
		return "EntidadeAssistencial [id=" + getId() + ", nome=" + getNome() + ", email=" + getEmail() + ", cnpj=" + getCnpj()
				+ ", senha=" + getSenha() + ", qtdBeneficiados=" + qtdBeneficiados +  ", "
						+ getEndereco() + ", " + getTelefone() + "] \n";
	}
	
	


	
	

}
