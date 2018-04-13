package view;

import java.sql.Connection;
import java.util.List;

import model.Assalariados;
import controller.AssalariadosJdbcDAO;
import controller.JdbUtil;

public class assalariadoVIEW {
	public static void main(String args[]) {
		try {
			Assalariados assalariados = new Assalariados();//model
				
			assalariados.setSalario("2000.00");//model
			assalariados.setIDEmpregado(1);//model

			
			Connection connection = JdbUtil.getConnection();//controller
			AssalariadosJdbcDAO assalariadosJdbcDAO = new AssalariadosJdbcDAO(connection);//controller
			
			//assalariadosJdbcDAO.salvar(assalariados);
			assalariadosJdbcDAO.listar();
			//assalariadosJdbcDAO.alterar(assalariados);
			//assalariadosJdbcDAO.excluir(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
