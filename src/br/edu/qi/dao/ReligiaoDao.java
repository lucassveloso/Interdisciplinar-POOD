package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Religiao;

public class ReligiaoDao extends GenericDao implements IDao<Religiao> {

	private static final String SELECT = "select * from "
			+ "religiao where Id_religiao=?";

	private static final String FINDALL = "select * from religiao";


	public Religiao find(Religiao obj) throws Exception {
		Religiao l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdReligiao());
			if (rs.next()) {
				return l = new Religiao(
						Integer.parseInt(rs.getString("Id_religiao")),
						rs.getString("descricao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Religiao> findAll() throws Exception {
		ArrayList<Religiao> l = new ArrayList<Religiao>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Religiao(
						Integer.parseInt(rs.getString("Id_religiao")),
						rs.getString("descricao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Religiões! "
							+ e.getMessage());
		}
		return l;
	}


	@Override
	public void save(Religiao obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Religiao obj) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
