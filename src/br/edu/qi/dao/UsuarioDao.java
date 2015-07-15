package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Usuario;

public class UsuarioDao extends GenericDao implements IDao<Usuario> {

	private static final String INSERT = "insert into "
			+ "Usuarios values(?,?,?)";

	private static final String SELECT = "select * from "
			+ "Usuarios where login=?";

	private static final String FINDALL = "select * from Usuarios";

	public void save(Usuario obj) throws Exception {
		executeSQL(INSERT, obj.getLogin(),
				obj.getSenha(),obj.getIdPessoa());
	}

	public Usuario find(Usuario obj) throws Exception {
		Usuario l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getLogin());
			if (rs.next()) {
				return l = new Usuario(
						rs.getString("login"),
						rs.getString("senha"), 
						rs.getInt("Id_pessoa"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Usuario> findAll() throws Exception {
		ArrayList<Usuario> l = new ArrayList<Usuario>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Usuario(
						rs.getString("login"),
						rs.getString("senha"), 
						rs.getInt("Id_pessoa")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Usuarios! "
							+ e.getMessage());
		}
		return l;
	}

}
