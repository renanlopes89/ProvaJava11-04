package model;

public class Comissionados {
	private Integer id;
	private String totalvenda;
	private String taxacomissao;
	private int id_empregado;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTotalVenda() {
		return totalvenda;
	}
	public void setTotalVenda(String totalvenda) {
		this.totalvenda = totalvenda;
	}
	public String getTaxaComissao() {
		return taxacomissao;
	}
	public void setTaxaComissao(String taxacomissao) {
		this.taxacomissao = taxacomissao;
	}
	public int getIDEmpregado() {
		return id_empregado;
	}
	public void setIDEmpregado(int id_empregado) {
		this.id_empregado = id_empregado;
	}
}
