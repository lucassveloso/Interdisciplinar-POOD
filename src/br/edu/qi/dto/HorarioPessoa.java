package br.edu.qi.dto;

public class HorarioPessoa {

	private int idPessoa;
	private int idHorario;

	public HorarioPessoa(int idPessoa, int idHorario) {
		this.idPessoa = idPessoa;
		this.idHorario = idHorario;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

}
