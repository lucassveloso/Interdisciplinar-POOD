package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Curso;

public class CursoDao extends GenericDao implements IDao<Curso> {

	private static final String INSERT = "insert into "
			+ "Cursos values(?,?)";

	private static final String SELECT = "select * from "
			+ "Cursos where Id_curso=?";

	private static final String FINDALL = "select * from Cursos";

	public void save(Curso obj) throws Exception {
		executeSQL(INSERT, obj.getIdCurso(),
				obj.getDescricao());
	}

	public Curso find(Curso obj) throws Exception {
		Curso l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdCurso());
			if (rs.next()) {
				return l = new Curso(
						rs.getInt("Id_curso"),
						rs.getString("descricao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Curso> findAll() throws Exception {
		ArrayList<Curso> l = new ArrayList<Curso>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Curso(
						rs.getInt("Id_curso"),
						rs.getString("F_pagamento")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Cursos! "
							+ e.getMessage());
		}
		return l;
	}

}
