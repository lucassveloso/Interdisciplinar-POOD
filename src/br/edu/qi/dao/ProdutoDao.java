package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Produto;

public class ProdutoDao extends GenericDao implements IDao<Produto> {

	private static final String INSERT = "insert into "
			+ "Produtos values(?,?,?)";

	private static final String SELECT = "select * from "
			+ "Produtos where Id_item=?";

	private static final String FINDALL = "select * from Produtos";

	public void save(Produto obj) throws Exception {
		executeSQL(INSERT,obj.getIdItem(), obj.getQuantidade(),
				obj.getLocal());
	}

	public Produto find(Produto obj) throws Exception {
		Produto l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdItem());
			if (rs.next()) {
				return l = new Produto(
						rs.getInt("Id_item"),
						rs.getInt("quantidade"), 
						rs.getString("local"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}
	
	public Produto find(int id) throws Exception {
		Produto l = null;
		try {
			ResultSet rs = executeQuery(SELECT, id);
			if (rs.next()) {
				return l = new Produto(
						rs.getInt("Id_item"),
						rs.getInt("quantidade"), 
						rs.getString("local"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Produto> findAll() throws Exception {
		ArrayList<Produto> l = new ArrayList<Produto>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Produto(
						rs.getInt("Id_item"),
						rs.getInt("quantidade"), 
						rs.getString("local")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Produtos! "
							+ e.getMessage());
		}
		return l;
	}

}
