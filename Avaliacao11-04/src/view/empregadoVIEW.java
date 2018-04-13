package view;

import java.sql.Connection;
import java.util.List;

import model.Empregados;
import controller.EmpregadosJdbcDAO;
import controller.JdbUtil;

public class empregadoVIEW {
	public static void main(String args[]) {
		try {
			Empregados empregados = new Empregados();//model
				
			empregados.setNome("José renan");//model
			empregados.setSobrenome("Alcântara lopes");//model
			empregados.setCPF("34468715863");//model
			
			Connection connection = JdbUtil.getConnection();//controller
			EmpregadosJdbcDAO empregadosJdbcDAO = new EmpregadosJdbcDAO(connection);//controller
			
			empregadosJdbcDAO.salvar(empregados);
			//empregadosJdbcDAO.listar();
			//empregadosJdbcDAO.alterar(empregados);
			//empregadosJdbcDAO.excluir(2);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
