package br.edu.qi.dto;

import java.util.Date;

public class Turma {

	private int idTurma;
	private int idCurso;
	private int idProfessor;
	private int capacidade;
	private Date data_inicio;
	private Date data_fim;
	private String tema;

	public Turma(int idTurma, int idCurso, int idProfessor, int capacidade, Date data_inicio,
			Date data_fim, String tema) {
		this.idTurma = idTurma;
		this.idCurso = idCurso;
		this.idProfessor = idProfessor;
		this.capacidade = capacidade;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.tema = tema;
	}
	
	public Turma( int idCurso, int idProfessor, int capacidade, Date data_inicio,
			Date data_fim, String tema) {
		this.idCurso = idCurso;
		this.idProfessor = idProfessor;
		this.capacidade = capacidade;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.tema = tema;
	}

	public Turma() {
		// TODO Auto-generated constructor stub
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	
}
