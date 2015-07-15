package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Professor;

public class ProfessorDao extends GenericDao implements IDao<Professor> {

	private static final String INSERT = "insert into "
			+ "Professores values(?,?)";

	private static final String SELECT = "select * from "
			+ "Professores where Id_pessoa=?";

	private static final String FINDALL = "select * from Professores";

	public void save(Professor obj) throws Exception {
		executeSQL(INSERT,obj.getIdPessoa(),obj.getFormacao());
	}

	public Professor find(Professor obj) throws Exception {
		Professor l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdPessoa());
			if (rs.next()) {
				return l = new Professor(
						rs.getInt("Id_pessoa"),
						rs.getString("formacao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Professor> findAll() throws Exception {
		ArrayList<Professor> l = new ArrayList<Professor>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add( new Professor(
						rs.getInt("Id_pessoa"),
						rs.getString("formacao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Professores! "
							+ e.getMessage());
		}
		return l;
	}



}
