package br.edu.qi.dto;

import java.sql.Date;

public class Contato {
	public String nome;
	public String apelido;
	public String telefone;
	public String celular;
	public String email;
	public Date dataNascimento;

	public Contato(String _nome, String _apelido, String _telefone,
			String _celular, String _email, Date _dataNascimento) {
		nome = _nome;
		apelido = _apelido;
		telefone = _telefone;
		celular = _celular;
		email = _email;
		dataNascimento = _dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
