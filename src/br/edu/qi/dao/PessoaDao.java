package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Pessoa;

public class PessoaDao extends GenericDao implements IDao<Pessoa> {

	private static final String INSERT = "insert into "
			+ "pessoas values(?,?,?,?,?,?,?,?)";

	private static final String SELECT = "select * from "
			+ "pessoas where Id_pessoa=?";

	private static final String FINDALL = "select * from pessoas";

	public void save(Pessoa obj) throws Exception {
		executeSQL(INSERT, 
				obj.getIdPessoa(),
				obj.getCep(),
				obj.getLogradouro(),
				obj.getNomeSocial(),
				obj.getNome(),
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
						Integer.parseInt(rs.getString("Id_pessoa")),
						Integer.parseInt(rs.getString("CEP")),
						rs.getString("Logradouro"),
						rs.getString("nome_social"),
						rs.getString("nome"),
						Integer.parseInt(rs.getString("Id_etinia")),
						Integer.parseInt(rs.getString("Id_religiao")),
						Integer.parseInt(rs.getString("Id_sexo")));
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
				l.add(new Pessoa(
						Integer.parseInt(rs.getString("Id_pessoa")),
						Integer.parseInt(rs.getString("CEP")),
						rs.getString("Logradouro"),
						rs.getString("nome_social"),
						rs.getString("nome"),
						Integer.parseInt(rs.getString("Id_etinia")),
						Integer.parseInt(rs.getString("Id_religiao")),
						Integer.parseInt(rs.getString("Id_sexo"))));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Pessoas! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public void delete(Pessoa obj) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
