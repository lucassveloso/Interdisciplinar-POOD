package br.edu.qi.dto;

public class Usuario {

	private String login;
	private String senha;
	private int idPessoa;

	public Usuario(String login, String senha, int idPessoa) {
		this.login = login;
		this.senha = senha;
		this.idPessoa = idPessoa;
	}
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

}
