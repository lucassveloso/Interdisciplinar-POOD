package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Matricula;

public class MatriculaDao extends GenericDao {

	private static final String INSERT = "insert into "
			+ "Matricula values(?,?)";

	private static final String SELECTTURMA = "select * from "
			+ "Matricula where Id_turma=?";
	
	private static final String SELECTALUNO = "select * from "
			+ "Matricula where Id_pessoa=?";

	private static final String FINDALL = "select * from Matricula";

	public void save(Matricula obj) throws Exception {
		executeSQL(INSERT, obj.getIdTurma(),
				obj.getIdPessoa());
	}

	public ArrayList<Matricula> findAll() throws Exception {
		ArrayList<Matricula> l = new ArrayList<Matricula>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Matricula(
						rs.getInt("Id_turma"), 
						rs.getInt("Id_pessoa")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Matriculas! "
							+ e.getMessage());
		}
		return l;
	}
	
	public ArrayList<Matricula> findPorTurma(int id) throws Exception {
		ArrayList<Matricula> l = new ArrayList<Matricula>();
		try {
			ResultSet rs = executeQuery(SELECTTURMA,id);
			while (rs.next()) {
				l.add(new Matricula(
						rs.getInt("Id_turma"), 
						rs.getInt("Id_pessoa")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Matriculas! "
							+ e.getMessage());
		}
		return l;
	}
	
	public ArrayList<Matricula> findPorPessoa(int id) throws Exception {
		ArrayList<Matricula> l = new ArrayList<Matricula>();
		try {
			ResultSet rs = executeQuery(SELECTALUNO,id);
			while (rs.next()) {
				l.add(new Matricula(
						rs.getInt("Id_turma"), 
						rs.getInt("Id_pessoa")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Matriculas! "
							+ e.getMessage());
		}
		return l;
	}

}
