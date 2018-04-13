package view;

import java.sql.Connection;
import java.util.List;

import model.Horistas;
import controller.HoristasJdbcDAO;
import controller.JdbUtil;

public class horistaVIEW {
	public static void main(String args[]) {
		try {
			Horistas horistas = new Horistas();//model
				
			horistas.setPrecoHora("50.00");//model
			horistas.setHorasTrabalhadas("10.5");//model
			horistas.setIDEmpregado(1);//model

			
			Connection connection = JdbUtil.getConnection();//controller
			HoristasJdbcDAO horistasJdbcDAO = new HoristasJdbcDAO(connection);//controller
			
			//horistasJdbcDAO.salvar(horistas);
			horistasJdbcDAO.listar();
			//horistasJdbcDAO.alterar(horistas);
			//horistasJdbcDAO.excluir(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
