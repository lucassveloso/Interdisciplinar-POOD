package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Aluno;

public class AlunoDao extends GenericDao implements IDao<Aluno> {

	private static final String INSERT = "insert into "
			+ "alunos values(?,?)";

	private static final String SELECT = "select * from "
			+ "alunos where Id_pessoa=?";

	private static final String FINDALL = "select * from alunos";

	public void save(Aluno obj) throws Exception {
		executeSQL(INSERT, obj.getIdPessoa(),
				obj.getfPagamento());
	}

	public Aluno find(Aluno obj) throws Exception {
		Aluno l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdPessoa());
			if (rs.next()) {
				return l = new Aluno(
						rs.getInt("Id_pessoa"),
						rs.getString("F_pagamento"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Aluno> findAll() throws Exception {
		ArrayList<Aluno> l = new ArrayList<Aluno>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Aluno(
						rs.getInt("Id_pessoa"),
						rs.getString("F_pagamento")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Alunos! "
							+ e.getMessage());
		}
		return l;
	}

}
