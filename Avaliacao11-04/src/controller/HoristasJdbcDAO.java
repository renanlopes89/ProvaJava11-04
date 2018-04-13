package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Horistas;

public class HoristasJdbcDAO {
private Connection conn;
	
	
	public  HoristasJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Horistas c) throws SQLException {
		String sql = "insert into horista (precoHora, horasTrabalhadas, ID_empregado) values ('"+c.getPrecoHora()+"','"+c.getHorasTrabalhadas()+"','"+c.getIDEmpregado()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Horistas c) {
		String sql = "update horista set salario='"+c.getPrecoHora()+"','"+c.getHorasTrabalhadas()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void excluir(int id) {
		String sql = "delete from horista where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Horistas> listar() {
		String sql = "select * from horista";
        System.out.println(sql);		
        List<Horistas> horistas = new ArrayList<Horistas>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				Float precohora = rs.getFloat("precohora");
				Float horastrabalhadas = rs.getFloat("horastrabalhadas");
				int idempregado = rs.getInt("id_empregado");
				Horistas horista = new Horistas();
				horista.setId(id);
				horista.setPrecoHora("precohora");
				horista.setHorasTrabalhadas("horastrabalhadas");
				horista.setIDEmpregado(idempregado);
				System.out.println(id);
				System.out.println(precohora);
				System.out.println(horastrabalhadas);
				System.out.println(idempregado);
				System.out.println("------------");
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return horistas;
	}
}
