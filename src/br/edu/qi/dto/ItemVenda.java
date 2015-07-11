package br.edu.qi.dto;

public class ItemVenda {
	private int idItem;
	private int idVenda;
	private int quantidade;
	private float valor;

	public ItemVenda(int idItem, int idVenda, int quantidade, float valor) {
		this.idItem = idItem;
		this.idVenda = idVenda;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}
