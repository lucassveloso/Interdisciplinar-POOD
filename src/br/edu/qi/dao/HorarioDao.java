package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Horario;

public class HorarioDao extends GenericDao implements IDao<Horario> {

	private static final String SELECT = "select * from "
			+ "Horarios where Id_Horario=?";

	private static final String FINDALL = "select * from Horarios";


	public Horario find(Horario obj) throws Exception {
		Horario l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdHorario());
			if (rs.next()) {
				return l = new Horario(
						rs.getInt("Id_Horario"),
						rs.getString("dia"), 
						rs.getString("turno"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Horario> findAll() throws Exception {
		ArrayList<Horario> l = new ArrayList<Horario>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Horario(
						rs.getInt("Id_Horario"),
						rs.getString("dia"), 
						rs.getString("turno")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Horarios! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public void save(Horario obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
