package br.edu.qi.dto;

public class HorarioTurma {

	private int idTurma;
	private int idHorario;

	public HorarioTurma(int idTurma, int idHorario) {
		this.idTurma = idTurma;
		this.idHorario = idHorario;
	}

	public int getidTurma() {
		return idTurma;
	}

	public void setidTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

}
