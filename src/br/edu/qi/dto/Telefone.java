package br.edu.qi.dto;

public class Telefone {

	private int idTelefone;
	private int idPessoa;
	private String telefone;

	public Telefone(int idTelefone ,int idPessoa, String telefone) {
		this.idTelefone = idTelefone;
		this.idPessoa = idPessoa;
		this.telefone = telefone;
	}
	
	public Telefone(int idPessoa, String telefone) {
		this.idPessoa = idPessoa;
		this.telefone = telefone;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
