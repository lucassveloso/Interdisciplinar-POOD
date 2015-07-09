package br.edu.qi.dto;

public class Etnia {

	private int idEtnia;
	private String descricao;
	
	public Etnia(int idEtnia, String descricao) {
		super();
		this.idEtnia = idEtnia;
		this.descricao = descricao;
	}

	public int getIdEtnia() {
		return idEtnia;
	}

	public void setIdEtnia(int idEtnia) {
		this.idEtnia = idEtnia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	

}
