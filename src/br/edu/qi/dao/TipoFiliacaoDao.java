package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.TipoFiliacao;

public class TipoFiliacaoDao extends GenericDao implements IDao<TipoFiliacao> {

	private static final String SELECT = "select * from "
			+ "Tipo_Filiacao where Id_Tipo=?";

	private static final String FINDALL = "select * from Tipo_Filiacao";


	public TipoFiliacao find(TipoFiliacao obj) throws Exception {
		TipoFiliacao l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getidTipo());
			if (rs.next()) {
				return l = new TipoFiliacao(
						rs.getInt("Id_Tipo"),
						rs.getString("descricao"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<TipoFiliacao> findAll() throws Exception {
		ArrayList<TipoFiliacao> l = new ArrayList<TipoFiliacao>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new TipoFiliacao(
						rs.getInt("Id_Tipo"),
						rs.getString("descricao")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos os Tipos de Filiação! "
							+ e.getMessage());
		}
		return l;
	}


	@Override
	public void save(TipoFiliacao obj) throws Exception {
		// TODO Auto-generated method stub
		
	}



}
