package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Pessoa;

public class PessoaDao extends GenericDao{

	private static final String INSERT = "insert into "
			+ "pessoas(CEP,Logradouro,Nome_social,Nome,Tipo_Pessoa,Id_etnia,Id_religiao,Id_sexo) values(?,?,?,?,?,?,?,?)";

	private static final String SELECT = "select * from "
			+ "pessoas where Id_pessoa=?";
	
	private static final String FINDALL = "select * from pessoas";
	
	private static final String FINDALUNOS = "select * from pessoas where Tipo_Pessoa = 'aluno'";
	private static final String FINDPROFESSORES = "select * from pessoas where Tipo_Pessoa = 'professor'";
	private static final String FINDFUNCIONARIOS = "select * from pessoas where Tipo_Pessoa = 'funcionario'";

	public Pessoa save(Pessoa obj) throws Exception {
		executeSQL(INSERT,
				obj.getCep(),
				obj.getLogradouro(),
				obj.getNomeSocial(),
				obj.getNome(),
				obj.getTipoPessoa(),
				obj.getIdEtinia(),
				obj.getIdReligiao(),
				obj.getIdSexo());
		
		ArrayList<Pessoa> pessoas = findAll();
		return pessoas.get(pessoas.size()-1);
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
	
	public Pessoa find(int id) throws Exception {
		Pessoa l = null;
		try {
			ResultSet rs = executeQuery(SELECT, id);
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
						rs.getString("nome"),
						rs.getString("nome_social"),
						rs.getString("Logradouro"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
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

	
	public ArrayList<Pessoa> findAlunos() throws Exception {
		ArrayList<Pessoa> l = new ArrayList<Pessoa>();
		try {
			ResultSet rs = executeQuery(FINDALUNOS);
			while (rs.next()) {
				l.add( new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("nome"),
						rs.getString("nome_social"),
						rs.getString("Logradouro"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
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
	
	public ArrayList<Pessoa> findProfessores() throws Exception {
		ArrayList<Pessoa> l = new ArrayList<Pessoa>();
		try {
			ResultSet rs = executeQuery(FINDPROFESSORES);
			while (rs.next()) {
				l.add( new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("nome"),
						rs.getString("nome_social"),
						rs.getString("Logradouro"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
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
	
	public ArrayList<Pessoa> findFuncionarios() throws Exception {
		ArrayList<Pessoa> l = new ArrayList<Pessoa>();
		try {
			ResultSet rs = executeQuery(FINDFUNCIONARIOS);
			while (rs.next()) {
				l.add( new Pessoa(
						rs.getInt("Id_pessoa"),
						rs.getInt("CEP"),
						rs.getString("nome"),
						rs.getString("nome_social"),
						rs.getString("Logradouro"),
						rs.getString("Tipo_Pessoa"),
						rs.getInt("Id_etnia"),
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
