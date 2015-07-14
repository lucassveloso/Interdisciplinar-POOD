package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Telefone;

public class TelefoneDao extends GenericDao implements IDao<Telefone> {

	private static final String INSERT = "insert into "
			+ "telefones(telefones,id_Pessoa) values(?,?)";

	private static final String SELECT = "select * from "
			+ "telefones where Id_telefone=?";

	private static final String FINDALL = "select * from telefones";

	public void save(Telefone obj) throws Exception {
		executeSQL(INSERT, obj.getTelefone(),
				obj.getIdPessoa());
	}

	public Telefone find(Telefone obj) throws Exception {
		Telefone l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdTelefone());
			if (rs.next()) {
				return l = new Telefone(
						rs.getInt("Id_telefone"),
						rs.getInt("id_Pessoa"), 
						rs.getString("telefones"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Telefone> findAll() throws Exception {
		ArrayList<Telefone> l = new ArrayList<Telefone>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Telefone(
						rs.getInt("Id_telefone"),
						rs.getInt("id_Pessoa"), 
						rs.getString("telefones")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Telefones! "
							+ e.getMessage());
		}
		return l;
	}

}
