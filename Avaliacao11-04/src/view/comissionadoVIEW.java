package view;

import java.sql.Connection;
import java.util.List;

import model.Comissionados;
import controller.ComissionadosJdbcDAO;
import controller.JdbUtil;

public class comissionadoVIEW {
	public static void main(String args[]) {
		try {
			Comissionados comissionados = new Comissionados();//model
				
			comissionados.setTotalVenda("2000.00");//model
			comissionados.setTaxaComissao("10.1");//model
			comissionados.setIDEmpregado(1);//model

			
			Connection connection = JdbUtil.getConnection();//controller
			ComissionadosJdbcDAO comissionadosJdbcDAO = new ComissionadosJdbcDAO(connection);//controller
			
			comissionadosJdbcDAO.salvar(comissionados);
			//comissionadosJdbcDAO.listar();
			//comissionadosJdbcDAO.alterar(comissionados);
			//comissionadosJdbcDAO.excluir(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
