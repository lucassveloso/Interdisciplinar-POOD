package br.edu.qi.dto;

public class Deficiencia {

	private int idDeficiencia;
	private String descricao;
	private int grau;

	public Deficiencia(int idDeficiencia, String descricao, int grau) {
		this.idDeficiencia = idDeficiencia;
		this.descricao = descricao;
		this.grau = grau;
	}
	
	public Deficiencia(String descricao, int grau) {
		this.descricao = descricao;
		this.grau = grau;
	}

	public int getIdDeficiencia() {
		return idDeficiencia;
	}

	public void setIdDeficiencia(int idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

}
