package br.edu.qi.dto;


public class Sexo{

	private int idSexo;
	private String descricao;
	
	public Sexo(){
		
	}

	public Sexo(int idSexo, String descricao) {
		super();
		this.idSexo = idSexo;
		this.descricao = descricao;
	}

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
   
