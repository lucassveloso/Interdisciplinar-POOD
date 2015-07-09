package br.edu.qi.dto;

public class Horario {

	private int idHorario;
	private int idDia;
	private String descricao;
	public Horario(int idHorario, int idDia, String descricao) {
		super();
		this.idHorario = idHorario;
		this.idDia = idDia;
		this.descricao = descricao;
	}
	public int getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
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
