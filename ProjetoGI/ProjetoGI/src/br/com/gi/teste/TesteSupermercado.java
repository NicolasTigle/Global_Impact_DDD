package br.com.gi.teste;

import br.com.gi.resource.bo.SupermercadoBO;

import br.com.gi.resource.to.Endereco;
import br.com.gi.resource.to.Supermercado;
import br.com.gi.resource.to.Telefone;


public class TesteSupermercado {

	public static void main(String[] args) {
		
		SupermercadoBO sb = new SupermercadoBO();		
		  sb.inserir(new Supermercado( "BIG", "big@gmail.com", 48146598000158L, "tfyw4t2",
		  "23:00 �s 07:00", new Endereco( "06020010", "S�o Paulo", "Osasco",
		  "Vila Yara", "Avenida dos Autonomistas", 1828, "Pr�dio A"), new Telefone( 11, 967527852) )
		  );
		 
		  sb.atualiza(new Supermercado( 3L, "BIG", "big@gmail.com", 48146598000158L, "tfyw4t2",
				  "22:00 �s 07:00", new Endereco( "06020010", "S�o Paulo", "Osasco",
						  "Vila Yara", "Avenida dos Autonomistas", 1828, "Pr�dio A"), new Telefone( 11, 973532342) )
						  );
		
		 System.out.println(sb.listar()); 
		
		 System.out.println(sb.listarId(1L)); 
		 
		
	}
	
}
