package br.edu.qi.dto;

public class Filiacao {

	private int idFiliacao;
	private String descricao;
	private int idTipo;
	private int idFiliado;

	private int idFiliado2;

	public Filiacao(int idFiliacao, String descricao, int idTipo,
			int idFiliado, int idFiliado2) {
		this.idFiliacao = idFiliacao;
		this.descricao = descricao;
		this.idTipo = idTipo;
		this.idFiliado = idFiliado;
		this.idFiliado2 = idFiliado2;
	}
	
	public Filiacao(String descricao, int idTipo,
			int idFiliado, int idFiliado2) {
		this.descricao = descricao;
		this.idTipo = idTipo;
		this.idFiliado = idFiliado;
		this.idFiliado2 = idFiliado2;
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

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public int getIdFiliado() {
		return idFiliado;
	}

	public void setIdFiliado(int idFiliado) {
		this.idFiliado = idFiliado;
	}

	public int getIdFiliado2() {
		return idFiliado2;
	}

	public void setIdFiliado2(int idFiliado2) {
		this.idFiliado2 = idFiliado2;
	}

}
