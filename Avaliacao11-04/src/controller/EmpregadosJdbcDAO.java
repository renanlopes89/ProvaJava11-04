package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empregados;

public class EmpregadosJdbcDAO {
private Connection conn;
	
	
	public  EmpregadosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Empregados c) throws SQLException {
		String sql = "insert into empregado (nome, sobrenome, cpf) values ('"+c.getNome()+"','"+c.getSobrenome()+"','"+c.getCPF()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Empregados c) {
		String sql = "update empregado set nome='"+c.getNome()+"',sobrenome='"+c.getSobrenome()+"',CPF='"+c.getCPF()+"';";
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
		String sql = "delete from empregado where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Empregados> listar() {
		String sql = "select * from empregado";
        System.out.println(sql);		
        List<Empregados> empregados = new ArrayList<Empregados>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String cpf = rs.getString("cpf");
				Empregados empregado = new Empregados();
				empregado.setId(id);
				empregado.setNome(nome);
				empregado.setSobrenome(sobrenome);
				empregado.setCPF(cpf);
				//empregados.add(empregado);
				System.out.println(id);
				System.out.println(nome);
				System.out.println(sobrenome);
				System.out.println(cpf);
				System.out.println("------------");
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empregados;
	}
}
