package br.com.gi.resource.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gi.resource.to.Endereco;
import br.com.gi.resource.to.EntidadeAssistencial;
import br.com.gi.resource.to.Telefone;
import br.com.gi.resource.util.ConnectionFactory;

public class EntidadeAssistencialDAO {

	public boolean inserir(EntidadeAssistencial entidadeAssistencial) throws SQLException {
		int linhas = 0;
		Connection con = ConnectionFactory.createConnection();
		 
		 String sql = "INSERT INTO t_gi_entidade (id_entidade, cnpj_entidade, em_entidade, nm_entidade, sn_entidade, qtd_beneficiados) "
		 		+ "values (SQ_GI_ENTIDADE.NEXTVAL, ?, ?, ?, ?, ?)";

		 PreparedStatement ps1 = con.prepareStatement(sql);
		 ps1.setLong(1, entidadeAssistencial.getCnpj());
		 ps1.setString(2, entidadeAssistencial.getEmail());
		 ps1.setString(3, entidadeAssistencial.getNome());
		 ps1.setString(4, entidadeAssistencial.getSenha());
		 ps1.setInt(5, entidadeAssistencial.getQtdBeneficiados());
		 
		 
		 if (ps1.executeUpdate() > 0) linhas += 1;

		String sql2 = "INSERT INTO t_gi_endereco (id_end, id_entidade, cep_end, estado_end, cidade_end, bairro_end, rua_end, nr_end) " +
		 "values (SQ_GI_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		 PreparedStatement ps2 = con.prepareStatement(sql2);
		 ps2.setLong(1, ultimoId());
		 ps2.setString(2, entidadeAssistencial.getEndereco().getCep());
		 ps2.setString(3, entidadeAssistencial.getEndereco().getEstado());
		 ps2.setString(4, entidadeAssistencial.getEndereco().getCidade());
		 ps2.setString(5, entidadeAssistencial.getEndereco().getBairro());
		 ps2.setString(6, entidadeAssistencial.getEndereco().getRua());
		 ps2.setInt(7, entidadeAssistencial.getEndereco().getNumero());
		 
		if (ps2.executeUpdate() > 0) linhas+=1;
		
		
		String sql3 = "INSERT INTO t_gi_telefone (id_tel, id_entidade, ddd_tel, nr_tel) " +
					  "values (SQ_GI_TELEFONE.NEXTVAL, ?, ?, ?)";

				 PreparedStatement ps3 = con.prepareStatement(sql3);
				 ps3.setLong(1, ultimoId());
				 ps3.setInt(2, entidadeAssistencial.getTelefone().getDdd());
				 ps3.setInt(3, entidadeAssistencial.getTelefone().getNumero());
				 
				if (ps3.executeUpdate() > 0) linhas+=1;
				
				return linhas > 0;
	}
	
	public List<EntidadeAssistencial> buscar() throws SQLException {

		Connection con = ConnectionFactory.createConnection();

		 List<EntidadeAssistencial> listEntidadeAssistencial = new ArrayList<EntidadeAssistencial>();
		 String sql =  "select * from t_gi_entidade, t_gi_endereco, t_gi_telefone " +
                       "where t_gi_entidade.id_entidade = t_gi_endereco.id_entidade and t_gi_entidade.id_entidade = t_gi_telefone.id_entidade order by t_gi_entidade.id_entidade";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) { 

			 EntidadeAssistencial entidadeAssistencial = new EntidadeAssistencial( 
					 
					 rs.getLong("id_entidade"),
					 rs.getString("nm_entidade"),
					 rs.getString("em_entidade"), 
					 rs.getLong("cnpj_entidade"), 
					 rs.getString("sn_entidade"),
					 rs.getInt("qtd_beneficiados"),
					 new Endereco(
					 rs.getLong("id_end"),
					 rs.getString("cep_end"),
					 rs.getString("estado_end"), 
 					 rs.getString("cidade_end"), 
					 rs.getString("bairro_end"),
					 rs.getString("rua_end"),
					 rs.getInt("nr_end"),
					 rs.getString("complemento_end")    
					 ),
					 new Telefone(
					 rs.getLong("id_tel"),
					 rs.getInt("ddd_tel") ,
					 rs.getInt("nr_tel")
					 )  
				);
			 
			 listEntidadeAssistencial.add(entidadeAssistencial);	 
		 }
		 
		 return listEntidadeAssistencial;
		 
	}
	
	public EntidadeAssistencial buscarID(Long id) throws SQLException {
		
		 Connection con = ConnectionFactory.createConnection();

		 String sql = "select * from t_gi_entidade, t_gi_endereco, t_gi_telefone " +
		 "where t_gi_entidade.id_entidade = ? and t_gi_endereco.id_entidade = ? and t_gi_telefone.id_entidade = ?";

		 PreparedStatement ps = con.prepareStatement(sql);
		 
		 ps.setLong(1, id);
		 ps.setLong(2, id);
		 ps.setLong(3, id);
		 
		 ResultSet rs = ps.executeQuery();

		 EntidadeAssistencial entidadeAssistencial;
		  
		 if (!rs.next()) {
			 throw new RuntimeException("Entidade Assistencial não encontrada");
		 }
		 
		 entidadeAssistencial = new EntidadeAssistencial( 
				 
				 rs.getLong("id_entidade"),
				 rs.getString("nm_entidade"),
				 rs.getString("em_entidade"), 
				 rs.getLong("cnpj_entidade"), 
				 rs.getString("sn_entidade"),
				 rs.getInt("qtd_beneficiados"),
				 new Endereco(
				 rs.getLong("id_end"),
				 rs.getString("cep_end"),
				 rs.getString("estado_end"), 
					 rs.getString("cidade_end"), 
				 rs.getString("bairro_end"),
				 rs.getString("rua_end"),
				 rs.getInt("nr_end"),
				 rs.getString("complemento_end")    
				 ),
				 new Telefone(
				 rs.getLong("id_tel"),
				 rs.getInt("ddd_tel") ,
				 rs.getInt("nr_tel")
				 )  
			); 

		 return entidadeAssistencial;
		 
		 }

	public boolean update(EntidadeAssistencial entidadeAssistencial) throws SQLException {
		
		int linhas = 0;

		Connection con = ConnectionFactory.createConnection();
				
		String sql1 = "UPDATE t_gi_entidade set " +
		"t_gi_entidade.cnpj_entidade = ?," +
		"t_gi_entidade.em_entidade = ?," +
		"t_gi_entidade.nm_entidade = ?," +
		"t_gi_entidade.sn_entidade = ?," +
		"t_gi_entidade.qtd_beneficiados = ? " +
		"where t_gi_entidade.id_entidade = ?";
		
		PreparedStatement ps1 = con.prepareStatement(sql1);
		
		 ps1.setLong(1, entidadeAssistencial.getCnpj());
		 ps1.setString(2, entidadeAssistencial.getEmail());
		 ps1.setString(3, entidadeAssistencial.getNome());
		 ps1.setString(4, entidadeAssistencial.getSenha());
		 ps1.setInt(5, entidadeAssistencial.getQtdBeneficiados());
		 ps1.setLong(6, entidadeAssistencial.getId());
		 
		 if (ps1.executeUpdate() > 0) linhas += 1;

		 String sql2 = "UPDATE t_gi_endereco set " +
		"t_gi_endereco.cep_end=?," +
		"t_gi_endereco.estado_end=?," +
		"t_gi_endereco.cidade_end=?," +
		"t_gi_endereco.bairro_end=?," +
		"t_gi_endereco.rua_end=?," +
		"t_gi_endereco.nr_end=?," +
		"t_gi_endereco.complemento_end=? " +
		"where t_gi_endereco.id_entidade = ?"; 
		
		PreparedStatement ps2 = con.prepareStatement(sql2);

		 ps2.setString(1, entidadeAssistencial.getEndereco().getCep());
		 ps2.setString(2, entidadeAssistencial.getEndereco().getEstado());
		 ps2.setString(3, entidadeAssistencial.getEndereco().getCidade());
		 ps2.setString(4, entidadeAssistencial.getEndereco().getBairro());
		 ps2.setString(5, entidadeAssistencial.getEndereco().getRua());
		 ps2.setInt(6, entidadeAssistencial.getEndereco().getNumero());
		 ps2.setString(7, entidadeAssistencial.getEndereco().getComplemento());
		 ps2.setLong(8, entidadeAssistencial.getId());
 
		if (ps2.executeUpdate() > 0) linhas += 1;
	
		String sql3 = "UPDATE t_gi_telefone set " +
					  "t_gi_telefone.ddd_tel= ?," +
				      "t_gi_telefone.nr_tel=? " +
					  "where t_gi_telefone.id_entidade = ?";
		
		PreparedStatement ps3 = con.prepareStatement(sql3);

		 ps3.setInt(1, entidadeAssistencial.getTelefone().getDdd());
		 ps3.setInt(2, entidadeAssistencial.getTelefone().getNumero());
		 ps3.setLong(3, entidadeAssistencial.getId());

		 if (ps3.executeUpdate() > 0) linhas+=1;

		 return linhas > 0;

	}
	
	public int ultimoId() {
		
		try {
			Connection con = ConnectionFactory.createConnection();
			
			String sql = "select max(id_entidade) as ultimo_codigo from t_gi_entidade";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(); 
			rs.next();
		  	return rs.getInt("ultimo_codigo");
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
		
	}
}

