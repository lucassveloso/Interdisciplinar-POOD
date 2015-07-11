package br.edu.qi.dto;

public class DeficPessoa {

	private int idPessoa;
	private int idDeficiencia;

	public DeficPessoa(int idPessoa, int idDeficiencia) {
		this.idPessoa = idPessoa;
		this.idDeficiencia = idDeficiencia;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getIdDeficiencia() {
		return idDeficiencia;
	}

	public void setIdDeficiencia(int idDeficiencia) {
		this.idDeficiencia = idDeficiencia;
	}

}
