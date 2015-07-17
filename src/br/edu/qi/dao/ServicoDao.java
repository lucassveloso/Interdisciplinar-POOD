package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Servico;

public class ServicoDao extends GenericDao implements IDao<Servico> {

	private static final String INSERT = "insert into "
			+ "Servicos values(?,?,?)";

	private static final String SELECT = "select * from "
			+ "Servicos where Id_item=?";

	private static final String FINDALL = "select * from Servicos";

	public void save(Servico obj) throws Exception {
		executeSQL(INSERT,obj.getIdItem(), obj.getespecificacao(),
				obj.getduracao());
	}	

	public Servico find(Servico obj) throws Exception {
		Servico l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdItem());
			if (rs.next()) {
				return l = new Servico(
						rs.getInt("Id_item"),
						rs.getString("especificacao"), 
						rs.getInt("duracao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Servico> findAll() throws Exception {
		ArrayList<Servico> l = new ArrayList<Servico>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add( new Servico(
						rs.getInt("Id_item"),
						rs.getString("especificacao"), 
						rs.getInt("duracao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Servicos! "
							+ e.getMessage());
		}
		return l;
	}

}
