package br.edu.qi.dto;

public class TipoFiliacao {

	private int idFiliacao;
	private String descricao;

	public TipoFiliacao(int idFiliacao, String descricao) {
		super();
		this.idFiliacao = idFiliacao;
		this.descricao = descricao;
	}

	public int getIdFiliacao() {
		return idFiliacao;
	}

	public void setIdFiliacao(int idFiliacao) {
		this.idFiliacao = idFiliacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
