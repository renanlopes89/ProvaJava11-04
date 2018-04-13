package model;

public class Horistas {
	private Integer id;
	private String precohora;
	private String horastrabalhadas;
	private int id_empregado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPrecoHora() {
		return precohora;
	}
	public void setPrecoHora(String precohora) {
		this.precohora = precohora;
	}
	public String getHorasTrabalhadas() {
		return horastrabalhadas;
	}
	public void setHorasTrabalhadas(String horastrabalhadas) {
		this.horastrabalhadas = horastrabalhadas;
	}
	public int getIDEmpregado() {
		return id_empregado;
	}
	public void setIDEmpregado(int id_empregado) {
		this.id_empregado = id_empregado;
	}
}
