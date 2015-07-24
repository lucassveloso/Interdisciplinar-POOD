package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Turma;

public class TurmaDao extends GenericDao {

	private static final String INSERT = "insert into "
			+ "Turmas(id_Curso,id_Professor,capacidade,Data_fim,Data_inicio,Tema) values(?,?,?,?,?,?)";

	private static final String SELECT = "select * from "
			+ "Turmas where Id_Turma=?";

	private static final String FINDALL = "select * from Turmas";
	
	private static final String UPDATECAPACIDADE = "UPDATE Turmas SET capacidade=? WHERE Id_turma=?";

	public Turma save(Turma obj) throws Exception {
		executeSQL(INSERT, obj.getIdCurso(), obj.getIdProfessor(),
				obj.getCapacidade(),
				obj.getData_fim(),
				obj.getData_inicio(),
				obj.getTema());
		
		ArrayList<Turma> turmas = findAll();
		return turmas.get(turmas.size()-1);
	}

	public Turma find(Turma obj) throws Exception {
		Turma l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdTurma());
			if (rs.next()) {
				return l = new Turma(
						rs.getInt("Id_Turma"),
						rs.getInt("Id_Curso"), 
						rs.getInt("Id_Professor"),
						rs.getInt("capacidade"),
						rs.getDate("Data_inicio"),
						rs.getDate("Data_fim"),
						rs.getString("tema")
						);
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Turma> findAll() throws Exception {
		ArrayList<Turma> l = new ArrayList<Turma>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Turma(
						rs.getInt("Id_Turma"),
						rs.getInt("Id_Curso"), 
						rs.getInt("Id_Professor"),
						rs.getInt("capacidade"),
						rs.getDate("Data_inicio"),
						rs.getDate("Data_fim"),
						rs.getString("tema")
						));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Turmas! "
							+ e.getMessage());
		}
		return l;
	}
	
	public void UpdateCapacidade(int capacidadeAtualizada, int id) throws Exception {
		try {
			executeSQL(UPDATECAPACIDADE, capacidadeAtualizada, id);
		} catch (Exception e) {
			throw new Exception("Não foi possivel dar update na capacidade da turma! " + e.getMessage());
		}
	}

}
