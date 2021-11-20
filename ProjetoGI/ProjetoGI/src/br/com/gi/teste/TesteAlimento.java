package br.com.gi.teste;

import br.com.gi.resource.bo.AlimentoBO;
import br.com.gi.resource.to.Alimento;


public class TesteAlimento {

	public static void main(String[] args) {
		
		AlimentoBO ab = new AlimentoBO();		

		ab.inserir(new Alimento(1L, "Batata", "Legume", 40, "27/11/2021", "Natural"));
		
		ab.atualiza(new Alimento(3L, 1L ,"Batata", "Legume", 50, "27/11/2021", "Natural"));
		
		System.out.println(ab.listar());
		System.out.println(ab.listarId(3L));
		
	}
	
}
