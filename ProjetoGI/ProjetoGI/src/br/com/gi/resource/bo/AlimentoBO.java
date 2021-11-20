package br.com.gi.resource.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.gi.resource.dao.AlimentoDAO;
import br.com.gi.resource.to.Alimento;

public class AlimentoBO {

private AlimentoDAO ad = null;
	
	public List<Alimento> listar(){
		
		try {
			ad = new AlimentoDAO();
			return ad.buscar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Alimento listarId(Long id){
		
		try {
			ad = new AlimentoDAO();
			return ad.buscarID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public boolean inserir(Alimento alimento){		
		try {
			ad = new AlimentoDAO();
			return ad.inserir(alimento);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
	public boolean atualiza(Alimento alimento){		
		try {
			ad = new AlimentoDAO();
			return ad.update(alimento);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
}
