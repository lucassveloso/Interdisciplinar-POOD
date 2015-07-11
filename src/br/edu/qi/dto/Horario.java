package br.edu.qi.dto;

public class Horario {

	private int idHorario;
	private String dia;
	private String turno;

	public Horario(int idHorario, String dia, String turno) {
		this.idHorario = idHorario;
		this.dia = dia;
		this.turno = turno;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}
