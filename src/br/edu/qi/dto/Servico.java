package br.edu.qi.dto;

public class Servico {

	private int idItem;
	private int duracao;
	private String especificacao;

	public Servico(int idItem, String especificacao, int duracao) {
		this.idItem = idItem;
		this.duracao = duracao;
		this.especificacao = especificacao;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getduracao() {
		return duracao;
	}

	public void setduracao(int duracao) {
		this.duracao = duracao;
	}

	public String getespecificacao() {
		return especificacao;
	}

	public void setespecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

}
