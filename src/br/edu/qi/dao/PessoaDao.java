package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Pessoa;

public class PessoaDao extends GenericDao implements IDao<Pessoa> {

	private static final String INSERT = "insert into "
			+ "pessoas(CEP,Logradouro,Nome_social,Nome,Tipo_Pessoa,Id_etnia,Id_religiao,Id_sexo) values(?,?,?,?,?,?,?,?)";

	private static final String SELECT = "select * from "
			+ "pessoas where Id_pessoa=?";

	private static final String SELECTSEMID = "select * from "
			+ "pessoas where nome=? and cep=? and Logradouro=?";
	
	private static final String FINDALL = "select * from pessoas";

	public void save(Pessoa obj) throws Exception {
		executeSQL(INSERT,
				obj.getCep(),
				obj.getLogradouro(),
				obj.getNomeSocial(),
				obj.getNome(),
				obj.getTipoPessoa(),
				obj.getIdEtinia(),
				obj.getIdReligiao(),
				obj.getIdSexo());
	}

	public Pessoa find(Pessoa obj) throws Exception {
		Pessoa l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdPessoa());
			if (rs.next()) {
				return l = new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("Logradouro"),
						rs.getString("nome_social"),
						rs.getString("nome"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
						rs.getInt("Id_religiao"),
						rs.getInt("Id_sexo"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}
	
	public Pessoa findSemId(Pessoa obj) throws Exception {
		Pessoa l = null;
		try {
			ResultSet rs = executeQuery(SELECTSEMID, obj.getNome(),obj.getCep(),obj.getLogradouro());
			if (rs.next()) {
				return l = new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("Logradouro"),
						rs.getString("nome_social"),
						rs.getString("nome"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
						rs.getInt("Id_religiao"),
						rs.getInt("Id_sexo"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Pessoa> findAll() throws Exception {
		ArrayList<Pessoa> l = new ArrayList<Pessoa>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add( new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("Logradouro"),
						rs.getString("nome_social"),
						rs.getString("nome"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etinia"),
						rs.getInt("Id_religiao"),
						rs.getInt("Id_sexo")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Pessoas! "
							+ e.getMessage());
		}
		return l;
	}



}
