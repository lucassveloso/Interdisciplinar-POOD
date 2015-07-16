package br.edu.qi.dto;

public class TipoFiliacao {

	private int idTipo;
	private String descricao;

	public TipoFiliacao(int idTipo, String descricao) {
		super();
		this.idTipo = idTipo;
		this.descricao = descricao;
	}

	public int getidTipo() {
		return idTipo;
	}

	public void setidTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
