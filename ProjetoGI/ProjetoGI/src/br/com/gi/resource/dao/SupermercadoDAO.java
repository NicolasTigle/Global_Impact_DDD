package br.com.gi.resource.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gi.resource.to.Endereco;
import br.com.gi.resource.to.Supermercado;
import br.com.gi.resource.to.Telefone;
import br.com.gi.resource.util.ConnectionFactory;

public class SupermercadoDAO {

	public boolean inserir(Supermercado supermercado) throws SQLException {
		int linhas = 0;
		Connection con = ConnectionFactory.createConnection();
		 
		 String sql = "INSERT INTO t_gi_supermercado (id_sm, cnpj_sm, em_sm, nm_sm, sn_sm, hr_funcionamento) " +
		"values (SQ_GI_SUPERMERCADO.NEXTVAL, ?, ?, ?, ?, ?)";

		 PreparedStatement ps1 = con.prepareStatement(sql);
		 ps1.setLong(1, supermercado.getCnpj());
		 ps1.setString(2, supermercado.getEmail());
		 ps1.setString(3, supermercado.getNome());
		 ps1.setString(4, supermercado.getSenha());
		 ps1.setString(5, supermercado.getHorarioFuncionamento());
		 
		 
		 if (ps1.executeUpdate() > 0) linhas += 1;

		String sql2 = "INSERT INTO t_gi_endereco (id_end, id_sm, cep_end, estado_end, cidade_end, bairro_end, rua_end, nr_end) " +
		 "values (SQ_GI_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		 PreparedStatement ps2 = con.prepareStatement(sql2);
		 ps2.setLong(1, ultimoId());
		 ps2.setString(2, supermercado.getEndereco().getCep());
		 ps2.setString(3, supermercado.getEndereco().getEstado());
		 ps2.setString(4, supermercado.getEndereco().getCidade());
		 ps2.setString(5, supermercado.getEndereco().getBairro());
		 ps2.setString(6, supermercado.getEndereco().getRua());
		 ps2.setInt(7, supermercado.getEndereco().getNumero());
		 
		if (ps2.executeUpdate() > 0) linhas+=1;
		
		
		String sql3 = "INSERT INTO t_gi_telefone (id_tel, id_sm, ddd_tel, nr_tel)" +
					  "values (SQ_GI_TELEFONE.NEXTVAL, ?, ?, ?)";

				 PreparedStatement ps3 = con.prepareStatement(sql3);
				 ps3.setLong(1, ultimoId());
				 ps3.setInt(2, supermercado.getTelefone().getDdd());
				 ps3.setInt(3, supermercado.getTelefone().getNumero());
				 
				if (ps3.executeUpdate() > 0) linhas+=1;
				
				return linhas > 0;
	}
	
	public List<Supermercado> buscar() throws SQLException {

		Connection con = ConnectionFactory.createConnection();

		 List<Supermercado> listSupermercado = new ArrayList<Supermercado>();
		 String sql =  "select * from t_gi_supermercado, t_gi_endereco, t_gi_telefone " +
                       "where t_gi_supermercado.id_sm = t_gi_endereco.id_sm and t_gi_supermercado.id_sm = t_gi_telefone.id_sm order by t_gi_supermercado.id_sm";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) { 

			 Supermercado supermercado = new Supermercado( 
					 
					 rs.getLong("id_sm"),
					 rs.getString("nm_sm"),
					 rs.getString("em_sm"), 
					 rs.getLong("cnpj_sm"), 
					 rs.getString("sn_sm"),
					 rs.getString("hr_funcionamento"),
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
			 
			 listSupermercado.add(supermercado);	 
		 }
		 
		 return listSupermercado;
		 
	}
	
	public Supermercado buscarID(Long id) throws SQLException {
		
		 Connection con = ConnectionFactory.createConnection();

		 String sql = "select * from t_gi_supermercado, t_gi_endereco, t_gi_telefone" +
		 " where t_gi_supermercado.id_sm = ? and t_gi_endereco.id_sm = ? and t_gi_telefone.id_sm = ?";

		 PreparedStatement ps = con.prepareStatement(sql);
		 
		 ps.setLong(1, id);
		 ps.setLong(2, id);
		 ps.setLong(3, id);
		 
		 ResultSet rs = ps.executeQuery();

		 Supermercado supermercado;
		  
		 if (!rs.next()) {
			 throw new RuntimeException("Supermercado não encontrado");
		 }
		 
		 supermercado = new Supermercado( 
					 
					 rs.getLong("id_sm"),
					 rs.getString("nm_sm"),
					 rs.getString("em_sm"), 
					 rs.getLong("cnpj_sm"), 
					 rs.getString("sn_sm"),
					 rs.getString("hr_funcionamento"),
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

		 return supermercado;
		 
		 }

	public boolean update(Supermercado supermercado) throws SQLException {
		
		int linhas = 0;

		Connection con = ConnectionFactory.createConnection();
				
		String sql1 = "UPDATE t_gi_supermercado set " +
		"t_gi_supermercado.cnpj_sm = ?," +
		"t_gi_supermercado.em_sm = ?," +
		"t_gi_supermercado.nm_sm = ?," +
		"t_gi_supermercado.sn_sm = ?," +
		"t_gi_supermercado.hr_funcionamento = ? " +
		"where t_gi_supermercado.id_sm = ?";
		
		PreparedStatement ps1 = con.prepareStatement(sql1);
		
		 ps1.setLong(1, supermercado.getCnpj());
		 ps1.setString(2, supermercado.getEmail());
		 ps1.setString(3, supermercado.getNome());
		 ps1.setString(4, supermercado.getSenha());
		 ps1.setString(5, supermercado.getHorarioFuncionamento());
		 ps1.setLong(6, supermercado.getId());
		 
		 if (ps1.executeUpdate() > 0) linhas += 1;

		 String sql2 = "UPDATE t_gi_endereco set " +
		"t_gi_endereco.cep_end=?," +
		"t_gi_endereco.estado_end=?," +
		"t_gi_endereco.cidade_end=?," +
		"t_gi_endereco.bairro_end=?," +
		"t_gi_endereco.rua_end=?," +
		"t_gi_endereco.nr_end=?," +
		"t_gi_endereco.complemento_end=? " +
		"where t_gi_endereco.id_sm = ?"; 
		
		PreparedStatement ps2 = con.prepareStatement(sql2);

		 ps2.setString(1, supermercado.getEndereco().getCep());
		 ps2.setString(2, supermercado.getEndereco().getEstado());
		 ps2.setString(3, supermercado.getEndereco().getCidade());
		 ps2.setString(4, supermercado.getEndereco().getBairro());
		 ps2.setString(5, supermercado.getEndereco().getRua());
		 ps2.setInt(6, supermercado.getEndereco().getNumero());
		 ps2.setString(7, supermercado.getEndereco().getComplemento());
		 ps2.setLong(8, supermercado.getId());
 
		if (ps2.executeUpdate() > 0) linhas += 1;
	
		String sql3 = "UPDATE t_gi_telefone set " +
					  "t_gi_telefone.ddd_tel= ?," +
				      "t_gi_telefone.nr_tel=? " +
					  "where t_gi_telefone.id_sm = ?";
		
		PreparedStatement ps3 = con.prepareStatement(sql3);

		 ps3.setInt(1, supermercado.getTelefone().getDdd());
		 ps3.setInt(2, supermercado.getTelefone().getNumero());
		 ps3.setLong(3, supermercado.getId());

		 if (ps3.executeUpdate() > 0) linhas+=1;

		 return linhas > 0;

	}
	
	public int ultimoId(){
		
		try {
			Connection con = ConnectionFactory.createConnection();
			
			String sql = "select max(id_sm) as ultimo_codigo from t_gi_supermercado";
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
