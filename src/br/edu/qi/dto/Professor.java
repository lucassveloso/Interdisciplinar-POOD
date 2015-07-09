package br.edu.qi.dto;

public class Professor {

	private int idPessoa;
	private String formacao;
	public Professor(int idPessoa, String formacao) {
		super();
		this.idPessoa = idPessoa;
		this.formacao = formacao;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
		
}
