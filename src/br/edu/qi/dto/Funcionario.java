package br.edu.qi.dto;

import java.sql.Date;

public class Funcionario {

	private int idPessoa;
	private Date dtAdmissao;
	private String cargo;

	public Funcionario(int idPessoa, Date dtAdmissao, String cargo) {
		this.idPessoa = idPessoa;
		this.dtAdmissao = dtAdmissao;
		this.cargo = cargo;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Date getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
