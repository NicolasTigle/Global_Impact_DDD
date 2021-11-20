package br.com.gi.resource.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.gi.resource.dao.EntidadeAssistencialDAO;
import br.com.gi.resource.to.EntidadeAssistencial;

public class EntidadeAssistencialBO {

private EntidadeAssistencialDAO ed = null;
	
	public List<EntidadeAssistencial> listar(){
		
		try {
			ed = new EntidadeAssistencialDAO();
			return ed.buscar();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public EntidadeAssistencial listarId(Long id){
		
		try {
			ed = new EntidadeAssistencialDAO();
			return ed.buscarID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}
	}
	
	public boolean inserir(EntidadeAssistencial entidadeAssistencial){		
		try {
			ed = new EntidadeAssistencialDAO();
			return ed.inserir(entidadeAssistencial);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
	public boolean atualiza(EntidadeAssistencial entidadeAssistencial){		
		try {
			ed = new EntidadeAssistencialDAO();
			return ed.update(entidadeAssistencial);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		}
	}
	
}
