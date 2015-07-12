package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Filiacao;

public class FiliacaoDao extends GenericDao implements IDao<Filiacao> {

	private static final String INSERT = "insert into "
			+ "Filiacao(Descricao,Id_tipo,Id_filiado,Id_filiado2) values(?,?,?,?)";

	private static final String SELECT = "select * from "
			+ "Filiacaos where Id_Filiacao=?";

	private static final String FINDALL = "select * from Filiacao";

	public void save(Filiacao obj) throws Exception {
		executeSQL(INSERT, obj.getDescricao(), obj.getIdTipo(),
				obj.getIdFiliado(), obj.getIdFiliado2());
	}

	public Filiacao find(Filiacao obj) throws Exception {
		Filiacao l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdFiliacao());
			if (rs.next()) {
				return l = new Filiacao(
						rs.getInt("Id_Filiacao"),
						rs.getString("descricao"),
						rs.getInt("Id_tipo"),
						rs.getInt("Id_filiado"),
						rs.getInt("Id_filiado2"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Filiacao> findAll() throws Exception {
		ArrayList<Filiacao> l = new ArrayList<Filiacao>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Filiacao(
						rs.getInt("Id_Filiacao"),
						rs.getString("descricao"),
						rs.getInt("Id_tipo"),
						rs.getInt("Id_filiado"),
						rs.getInt("Id_filiado2")));
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível achar todos as filiações! "
					+ e.getMessage());
		}
		return l;
	}

}
