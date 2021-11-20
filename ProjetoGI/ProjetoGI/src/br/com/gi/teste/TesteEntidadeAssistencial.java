package br.com.gi.teste;

import br.com.gi.resource.bo.EntidadeAssistencialBO;

import br.com.gi.resource.to.Endereco;
import br.com.gi.resource.to.EntidadeAssistencial;
import br.com.gi.resource.to.Telefone;

public class TesteEntidadeAssistencial {

	public static void main(String[] args) {
		
		EntidadeAssistencialBO eb = new EntidadeAssistencialBO();		
		
		  eb.inserir(new EntidadeAssistencial( "Ten Yad", "tenyad@gmail.com",
		  62442760000106L, "823r9uf2", 454, new Endereco( "01127000", "São Paulo",
		  "São Paulo", "Bom Retiro", "Newton Prado", 76 , ""), new Telefone( 11,
		  33342977) ) );
		 
		 
		
		  eb.atualiza(new EntidadeAssistencial(3L, "Ten Yad", "tenyad@gmail.com",
		  62442760000106L, "43tgdsf", 567, new Endereco( "01127000", "São Paulo",
		  "São Paulo", "Bom Retiro", "Newton Prado", 76, ""), new Telefone( 11,
		  33342977) ) );
		 
		
		 System.out.println(eb.listar()); 
		 System.out.println(eb.listarId(2L)); 
		 		
	}
	
}
