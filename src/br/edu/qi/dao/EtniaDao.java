package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Etnia;

public class EtniaDao extends GenericDao implements IDao<Etnia> {

	private static final String SELECT = "select * from "
			+ "etnias where Id_etnia=?";

	private static final String FINDALL = "select * from etnias";


	public Etnia find(Etnia obj) throws Exception {
		Etnia l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdEtnia());
			if (rs.next()) {
				return l = new Etnia(
						Integer.parseInt(rs.getString("Id_etnia")),
						rs.getString("descricao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Etnia> findAll() throws Exception {
		ArrayList<Etnia> l = new ArrayList<Etnia>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Etnia(
						Integer.parseInt(rs.getString("Id_etnia")),
						rs.getString("descricao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Etnias! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public void delete(Etnia obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Etnia obj) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
