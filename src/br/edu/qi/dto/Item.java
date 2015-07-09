package br.edu.qi.dto;

public class Item {

	private int idItem;
	private String descricao;
	private float valor;
	public Item(int idItem, String descricao, float valor) {
		super();
		this.idItem = idItem;
		this.descricao = descricao;
		this.valor = valor;
	}
	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
}
