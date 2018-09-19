package br.com.teste.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.teste.models.Equipamento;

public class EquipamentoDAO {
	private Connection con;

    public EquipamentoDAO(Connection connection) {
        this.con = connection;
    }
	
    public EquipamentoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
	
    public void adiciona(Equipamento e){
		String sql = "insert into equipamento (nome,local,adquirido) values (?,?,?)";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getLocal());
			stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()) ) ;
			
			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado!");
			
			con.close();
			
		}catch(SQLException erroSQL){
			throw new RuntimeException(erroSQL);
		}
    }

	public void Altera(Equipamento e){
		String sql = "UPDATE equipamento SET " +
		"nome=?, local=?, adquirido=? WHERE id=?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, e.getName());
			stmt.setString(2, e.getLocal());
			stmt.setDate(3, new Date(Calendar.getInstance().getTimeInMillis()) );
			stmt.setInt(4, e.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException erroSQL){
			throw new RuntimeException(erroSQL);
		}
	}
	
	public void Remove(Equipamento c){
		String sql = "DELETE FROM equipamento WHERE equip_id = ?";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, c.getId());
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
    
	public List<Equipamento> Show()
	{
		String sql = "select * from equipamento";
		
		try{
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Equipamento> equipamentos = new ArrayList<Equipamento>();
			
			
			while(rs.next())
			{
				Calendar cal = Calendar.getInstance();
				
				String id   		= rs.getString("equip_id");
				String nome 		= rs.getString("nome");
				String local 		= rs.getString("local");
				cal.setTime(rs.getDate("adquirido"));
				
				Equipamento e 		= new Equipamento();
				
				e.setId(Integer.parseInt(id));
				e.setName(nome);
				e.setLocal(local);
				e.setAdquirido(cal);
				
				equipamentos.add(e);
			}
			
			stmt.close();
			con.close();
			
			return equipamentos;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
}
