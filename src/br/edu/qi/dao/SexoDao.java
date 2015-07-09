package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Sexo;

public class SexoDao extends GenericDao implements IDao<Sexo> {

	private static final String SELECT = "select * from "
			+ "sexo where Id_sexo=?";

	private static final String FINDALL = "select * from sexo";


	public Sexo find(Sexo obj) throws Exception {
		Sexo l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdSexo());
			if (rs.next()) {
				return l = new Sexo(
						Integer.parseInt(rs.getString("Id_sexo")),
						rs.getString("descricao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Sexo> findAll() throws Exception {
		System.out.println("to no dao");
		ArrayList<Sexo> l = new ArrayList<Sexo>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Sexo(
						Integer.parseInt(rs.getString("Id_sexo")),
						rs.getString("descricao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos os Sexos! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public void delete(Sexo obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Sexo obj) throws Exception {
		// TODO Auto-generated method stub
		
	}


}
