package br.edu.qi.dto;

public class ProdTurma {

	private int idTurma;
	private int idItem;

	public ProdTurma(int idTurma, int idItem) {
		this.idTurma = idTurma;
		this.idItem = idItem;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

}
