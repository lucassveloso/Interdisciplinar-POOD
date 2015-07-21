package br.edu.qi.dto;

public class ProdutoItem {
	
	private Item item;
	private Produto produto;
	public ProdutoItem(Item item, Produto produto) {
		super();
		this.item = item;
		this.produto = produto;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
