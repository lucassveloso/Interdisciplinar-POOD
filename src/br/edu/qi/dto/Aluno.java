package br.edu.qi.dto;

public class Aluno {
	
	private int idPessoa;
	private String fPagamento;
	public Aluno(int idPessoa, String fPagamento) {
		super();
		this.idPessoa = idPessoa;
		this.fPagamento = fPagamento;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getfPagamento() {
		return fPagamento;
	}
	public void setfPagamento(String fPagamento) {
		this.fPagamento = fPagamento;
	}
	


}
