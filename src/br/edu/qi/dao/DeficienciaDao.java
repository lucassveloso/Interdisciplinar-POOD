package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Deficiencia;

public class DeficienciaDao extends GenericDao implements IDao<Deficiencia> {

	private static final String INSERT = "insert into "
			+ "deficiencias values(?,?,?)";;

	private static final String SELECT = "select * from "
			+ "deficiencias where Id_deficencia=?";

	private static final String FINDALL = "select * from deficiencias";

	public void save(Deficiencia obj) throws Exception {
		executeSQL(INSERT, obj.getIdDeficiencia(), obj.getDescricao(),
				obj.getGrau());
	}

	public Deficiencia find(Deficiencia obj) throws Exception {
		Deficiencia l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdDeficiencia());
			if (rs.next()) {
				return l = new Deficiencia(Integer.parseInt(rs
						.getString("Id_deficencia")),
						rs.getString("descricao"), Integer.parseInt(rs
								.getString("grau")));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Deficiencia> findAll() throws Exception {
		ArrayList<Deficiencia> l = new ArrayList<Deficiencia>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Deficiencia(Integer.parseInt(rs
						.getString("Id_deficencia")),
						rs.getString("descricao"), Integer.parseInt(rs
								.getString("grau"))));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Deficiencias! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public void delete(Deficiencia obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
