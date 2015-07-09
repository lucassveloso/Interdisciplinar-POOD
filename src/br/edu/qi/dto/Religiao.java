package br.edu.qi.dto;

public class Religiao {

	private int idReligiao;
	private String descricao;
	
	public Religiao(int idReligiao, String descricao) {
		super();
		this.idReligiao = idReligiao;
		this.descricao = descricao;
	}

	public int getIdReligiao() {
		return idReligiao;
	}

	public void setIdReligiao(int idReligiao) {
		this.idReligiao = idReligiao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
