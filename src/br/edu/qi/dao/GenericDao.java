package br.edu.qi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class GenericDao {

	protected void executeSQL(String sql, Object... parameters)
			throws Exception {
		try {
			PreparedStatement pstm = ConnectionManager.getInstance()
					.getConnection().prepareStatement(sql);

			for (int i = 0; i < parameters.length; i++) {
				pstm.setObject(i + 1, parameters[i]);
			}
			pstm.execute();

		} catch (Exception ex) {
			throw new Exception("Erro SQL: " + ex.getMessage());
		}
	}

	public ResultSet executeQuery(String sql, Object... parameters)
			throws Exception {
		PreparedStatement pstm = null;
		try {
			pstm = ConnectionManager.getInstance().getConnection()
					.prepareStatement(sql);
			for (int i = 0; i < parameters.length; i++) {
				pstm.setObject(i + 1, parameters[i]);

			}
			ResultSet rows = pstm.executeQuery();

			return rows;

		} catch (Exception e) {
			throw (e);
		} finally {

			ConnectionManager.getInstance().getConnection().close();
		}

	}
}
