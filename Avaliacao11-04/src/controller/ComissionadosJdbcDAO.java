package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Comissionados;

public class ComissionadosJdbcDAO {
private Connection conn;
	
	
	public  ComissionadosJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Comissionados c) throws SQLException {
		String sql = "insert into comissionado (totalVenda, taxaComissao, ID_empregado) values ('"+c.getTotalVenda()+"','"+c.getTaxaComissao()+"','"+c.getIDEmpregado()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Comissionados c) {
		String sql = "update comissionado set salario='"+c.getTotalVenda()+"','"+c.getTaxaComissao()+"';";
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
		String sql = "delete from comissionado where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Comissionados> listar() {
		String sql = "select * from comissionado";
        System.out.println(sql);		
        List<Comissionados> comissionados = new ArrayList<Comissionados>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				Float totalvenda = rs.getFloat("totalvenda");
				Float taxacomissao = rs.getFloat("taxacomissao");
				int idempregado = rs.getInt("id_empregado");
				Comissionados comissionado = new Comissionados();
				comissionado.setId(id);
				comissionado.setTotalVenda("totalVenda");
				comissionado.setTaxaComissao("taxaComissao");
				comissionado.setIDEmpregado(idempregado);
				System.out.println(id);
				System.out.println(totalvenda);
				System.out.println(taxacomissao);
				System.out.println(idempregado);
				System.out.println("------------");
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comissionados;
	}
}
