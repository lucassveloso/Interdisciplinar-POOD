package br.edu.qi.dto;

public class Dia {
	
	private int idDia;
	private String descricao;
	public Dia(int idDia, String descricao) {
		super();
		this.idDia = idDia;
		this.descricao = descricao;
	}
	public int getIdDia() {
		return idDia;
	}
	public void setIdDia(int idDia) {
		this.idDia = idDia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
