package br.edu.qi.dto;

public class Pessoa {

	private int idPessoa;
	private int cep;
	private String nome;
	private String nomeSocial;
	private String logradouro;
	private String tipoPessoa;
	private int idEtinia;
	private int idReligiao;
	private int idSexo;

	public Pessoa(int idPessoa, int cep, String nome, String nomeSocial,
			String logradouro, String tipoPessoa, int idEtinia, int idReligiao,
			int idSexo) {
		this.idPessoa = idPessoa;
		this.cep = cep;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.logradouro = logradouro;
		this.tipoPessoa = tipoPessoa;
		this.idEtinia = idEtinia;
		this.idReligiao = idReligiao;
		this.idSexo = idSexo;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getIdEtinia() {
		return idEtinia;
	}

	public void setIdEtinia(int idEtinia) {
		this.idEtinia = idEtinia;
	}

	public int getIdReligiao() {
		return idReligiao;
	}

	public void setIdReligiao(int idReligiao) {
		this.idReligiao = idReligiao;
	}

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
