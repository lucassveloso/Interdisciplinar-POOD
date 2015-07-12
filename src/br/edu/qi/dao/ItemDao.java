package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Item;

public class ItemDao extends GenericDao implements IDao<Item> {

	private static final String INSERT = "insert into "
			+ "item(descricao,valor) values(?,?)";

	private static final String SELECT = "select * from "
			+ "item where Id_Item=?";

	private static final String FINDALL = "select * from item";

	public void save(Item obj) throws Exception {
		executeSQL(INSERT,obj.getDescricao(),obj.getValor());
	}

	public Item find(Item obj) throws Exception {
		Item l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdItem());
			if (rs.next()) {
				return l = new Item(
						rs.getInt("Id_Item"),
						rs.getString("descricao"), 
						rs.getFloat("valor"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Item> findAll() throws Exception {
		ArrayList<Item> l = new ArrayList<Item>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Item(
						rs.getInt("Id_Item"),
						rs.getString("descricao"), 
						rs.getFloat("valor")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Items! "
							+ e.getMessage());
		}
		return l;
	}

}
