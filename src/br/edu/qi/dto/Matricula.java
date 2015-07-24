package br.edu.qi.dto;

public class Matricula {

	private int idPessoa;
	private int idTurma;
	public Matricula(int idTurma, int idPessoa) {
		this.idPessoa = idPessoa;
		this.idTurma = idTurma;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getIdTurma() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	
	
}
