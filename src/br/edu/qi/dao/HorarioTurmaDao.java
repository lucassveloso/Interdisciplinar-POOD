package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.HorarioPessoa;
import br.edu.qi.dto.HorarioTurma;

public class HorarioTurmaDao extends GenericDao implements IDao<HorarioTurma> {

	private static final String INSERT = "insert into "
			+ "horario_turmas values(?,?)";

	private static final String SELECTTURMA = "select * from "
			+ "horario_turmas where Id_turma=?";

	private static final String SELECTHORARIO = "select * from "
			+ "horario_turmas where Id_horario=?";
	
	private static final String FINDALL = "select * from horario_turmas";

	public void save(HorarioTurma obj) throws Exception {
		executeSQL(INSERT, obj.getIdHorario(), obj.getidTurma());
	}

	public HorarioTurma findTurma(int id) throws Exception {
		HorarioTurma l = null;
		try {
			ResultSet rs = executeQuery(SELECTTURMA, id);
			if (rs.next()) {
				return l = new HorarioTurma(rs.getInt("Id_turma"),rs.getInt("Id_horario"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}
	
	public ArrayList<HorarioTurma> findHorario(int id) throws Exception {
		ArrayList<HorarioTurma> l = new ArrayList<HorarioTurma>();
		try {
			ResultSet rs = executeQuery(SELECTHORARIO, id);
			while (rs.next()) {
				l.add(new HorarioTurma(rs.getInt("Id_turma"),rs.getInt("Id_horario")));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<HorarioTurma> findAll() throws Exception {
		ArrayList<HorarioTurma> l = new ArrayList<HorarioTurma>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new HorarioTurma(rs.getInt("Id_turma"),rs.getInt("Id_horario")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as HorarioTurma! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public HorarioTurma find(HorarioTurma obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
