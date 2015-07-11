package br.edu.qi.dto;

public class Produto {

	private int idItem;
	private int quantidade;
	private String local;

	public Produto(int idItem, int quantidade, String local) {
		this.idItem = idItem;
		this.quantidade = quantidade;
		this.local = local;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
