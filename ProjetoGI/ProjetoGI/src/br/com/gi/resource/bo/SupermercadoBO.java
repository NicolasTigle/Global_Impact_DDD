package br.com.gi.resource.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.gi.resource.dao.SupermercadoDAO;
import br.com.gi.resource.to.Supermercado;

public class SupermercadoBO {

private SupermercadoDAO sd = null;
	
	public List<Supermercado> listar(){
		
		try {
			sd = new SupermercadoDAO();
			return sd.buscar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Supermercado listarId(Long id){
		
		try {
			sd = new SupermercadoDAO();
			return sd.buscarID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public boolean inserir(Supermercado supermercado){		
		try {
			sd = new SupermercadoDAO();
			return sd.inserir(supermercado);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
	public boolean atualiza(Supermercado supermercado){		
		try {
			sd = new SupermercadoDAO();
			return sd.update(supermercado);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
}
