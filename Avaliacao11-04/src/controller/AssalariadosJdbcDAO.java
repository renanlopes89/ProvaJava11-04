package controller;
	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Assalariados;

public class AssalariadosJdbcDAO {
private Connection conn;
	
	
	public  AssalariadosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Assalariados c) throws SQLException {
		String sql = "insert into assalariado (salario, ID_empregado) values ('"+c.getSalario()+"','"+c.getIDEmpregado()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Assalariados c) {
		String sql = "update assalariado set salario='"+c.getSalario()+"';";
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
		String sql = "delete from assalariado where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Assalariados> listar() {
		String sql = "select * from assalariado";
        System.out.println(sql);		
        List<Assalariados> assalariados = new ArrayList<Assalariados>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				Float salario = rs.getFloat("salario");
				int idempregado = rs.getInt("id_empregado");
				Assalariados assalariado = new Assalariados();
				assalariado.setId(id);
				assalariado.setSalario("salario");
				assalariado.setIDEmpregado(idempregado);
				System.out.println(id);
				System.out.println(salario);
				System.out.println(idempregado);
				System.out.println("------------");
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return assalariados;
	}
}
