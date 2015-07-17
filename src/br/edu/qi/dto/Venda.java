package br.edu.qi.dto;

import java.util.Date;

public class Venda {
	private int idPessoa;
	private int idVenda;
	private float valorTotal;
	
	
	public Venda(int idPessoa, int idVenda, float valorTotal) {
		this.idPessoa = idPessoa;
		this.idVenda = idVenda;
		this.valorTotal = valorTotal;
	}
	public Venda(int idVenda, float valorTotal) {
		this.idVenda = idVenda;
		this.valorTotal = valorTotal;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	
	public float getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
