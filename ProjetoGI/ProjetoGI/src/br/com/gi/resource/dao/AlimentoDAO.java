package br.com.gi.resource.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gi.resource.to.Alimento;
import br.com.gi.resource.util.ConnectionFactory;

public class AlimentoDAO {

	public boolean inserir(Alimento alimento) throws SQLException {

		Connection con = ConnectionFactory.createConnection();
		 
		 String sql = "INSERT INTO t_gi_alimento (id_alimento, id_sm, nm_alimento, ctg_alimento, qtd_alimento, dt_validade, tp_alimento) "
		 		+ "values (SQ_GI_ALIMENTO.NEXTVAL, ?, ?, ?, ?, TO_DATE(?,'DD/MM/YYYY'), ?)";

		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setLong(1, alimento.getIdSupermercado());
		 ps.setString(2, alimento.getNome());
		 ps.setString(3, alimento.getCategoria());
		 ps.setInt(4, alimento.getQuantidade());
		 ps.setString(5, alimento.getDataValidade());
		 ps.setString(6, alimento.getTipo());
		 		 
		 return ps.executeUpdate() > 0;
		 
	}

	public List<Alimento> buscar() throws SQLException {

		Connection con = ConnectionFactory.createConnection();

		 List<Alimento> listAlimento = new ArrayList<Alimento>();
		 String sql =  "select * from t_gi_alimento order by id_alimento";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 while(rs.next()) { 

			 Alimento alimento = new Alimento( 
					 rs.getLong("id_alimento"),
					 rs.getLong("id_sm"),
					 rs.getString("nm_alimento"),
					 rs.getString("ctg_alimento"), 
					 rs.getInt("qtd_alimento"), 
					 rs.getString("dt_validade"),
					 rs.getString("tp_alimento") 
				);
			 
			 listAlimento.add(alimento);	 
		 }
		 
		 return listAlimento;
		 
	}
	
	public Alimento buscarID(Long id) throws SQLException {
		
		 Connection con = ConnectionFactory.createConnection();

		 String sql = "select * from t_gi_alimento where id_alimento = ?";

		 PreparedStatement ps = con.prepareStatement(sql);
		 
		 ps.setLong(1, id);
		 
		 ResultSet rs = ps.executeQuery();

		 Alimento alimento;
		  
		 if (!rs.next()) {
			 throw new RuntimeException("Alimento não encontrado");
		 }
		 
		 alimento = new Alimento( 
				 
				 rs.getLong("id_alimento"),
				 rs.getLong("id_sm"),
				 rs.getString("nm_alimento"),
				 rs.getString("ctg_alimento"), 
				 rs.getInt("qtd_alimento"), 
				 rs.getString("dt_validade"),
				 rs.getString("tp_alimento") 
			); 

		 return alimento;
		 
		 }
	
		public boolean update(Alimento alimento) throws SQLException {
			
			Connection con = ConnectionFactory.createConnection();
					
			String sql1 = "UPDATE t_gi_alimento set " +
			"t_gi_alimento.nm_alimento = ?," +
			"t_gi_alimento.ctg_alimento = ?," +
			"t_gi_alimento.qtd_alimento = ?," +
			"t_gi_alimento.dt_validade = TO_DATE(?,'DD/MM/YYYY')," +
			"t_gi_alimento.tp_alimento = ? " +
			"where t_gi_alimento.id_alimento = ?";
			
			PreparedStatement ps = con.prepareStatement(sql1);
			
			 ps.setString(1, alimento.getNome());
			 ps.setString(2, alimento.getCategoria());
			 ps.setInt(3, alimento.getQuantidade());
			 ps.setString(4, alimento.getDataValidade());
			 ps.setString(5, alimento.getTipo());
			 ps.setLong(6, alimento.getId());
			 
			 return ps.executeUpdate() > 0;
			 
		}
		
		public int ultimoId() {
			
			try {
				Connection con = ConnectionFactory.createConnection();
				
				String sql = "select max(id_alimento) as ultimo_codigo from t_gi_alimento";
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
