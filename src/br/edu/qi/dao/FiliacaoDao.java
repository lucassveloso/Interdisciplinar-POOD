package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Filiacao;

public class FiliacaoDao extends GenericDao implements IDao<Filiacao> {

	private static final String INSERT = "insert into "
			+ "Filiacao(nome,Id_tipo,Id_filiado) values(?,?,?)";

	private static final String SELECT = "select * from "
			+ "Filiacaos where Id_Filiacao=?";

	private static final String FINDALL = "select * from Filiacao";

	public void save(Filiacao obj) throws Exception {
		executeSQL(INSERT, obj.getNome(), obj.getIdTipo(),
				obj.getIdFiliado());
	}

	public Filiacao find(Filiacao obj) throws Exception {
		Filiacao l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdFiliacao());
			if (rs.next()) {
				return l = new Filiacao(
						rs.getInt("Id_Filiacao"),
						rs.getString("nome"),
						rs.getInt("Id_tipo"),
						rs.getInt("Id_filiado"));
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
						rs.getString("nome"),
						rs.getInt("Id_tipo"),
						rs.getInt("Id_filiado")));
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível achar todos as filiações! "
					+ e.getMessage());
		}
		return l;
	}

}
