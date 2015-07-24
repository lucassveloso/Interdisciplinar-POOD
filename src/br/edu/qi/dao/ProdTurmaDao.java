package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.ProdTurma;

public class ProdTurmaDao extends GenericDao implements IDao<ProdTurma> {

	private static final String INSERT = "insert into "
			+ "Prod_Turmas values(?,?)";

	private static final String SELECT = "select * from "
			+ "Prod_Turmas where Id_turma=?";

	private static final String FINDALL = "select * from Prod_Turmas";

	public void save(ProdTurma obj) throws Exception {
		executeSQL(INSERT, obj.getIdTurma(),
				obj.getIdItem());
	}

	public ProdTurma find(ProdTurma obj) throws Exception {
		ProdTurma l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdTurma());
			if (rs.next()) {
				return l = new ProdTurma(
						rs.getInt("Id_turma"),
						rs.getInt("Id_item"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<ProdTurma> findAll() throws Exception {
		ArrayList<ProdTurma> l = new ArrayList<ProdTurma>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new ProdTurma(
						rs.getInt("Id_turma"),
						rs.getInt("Id_item")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as ProdTurmas! "
							+ e.getMessage());
		}
		return l;
	}

}
