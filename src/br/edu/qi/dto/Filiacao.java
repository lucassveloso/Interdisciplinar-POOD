package br.edu.qi.dto;

public class Filiacao {

	private int idFiliacao;
	private String nome;
	private int idTipo;
	private int idFiliado;

	public Filiacao(int idFiliacao, String nome, int idTipo,
			int idFiliado ){
		this.idFiliacao = idFiliacao;
		this.nome = nome;
		this.idTipo = idTipo;
		this.idFiliado = idFiliado;
	}
	
	public Filiacao(String nome, int idTipo,
			int idFiliado) {
		this.nome = nome;
		this.idTipo = idTipo;
		this.idFiliado = idFiliado;;
	}

	public int getIdFiliacao() {
		return idFiliacao;
	}

	public void setIdFiliacao(int idFiliacao) {
		this.idFiliacao = idFiliacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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


}
