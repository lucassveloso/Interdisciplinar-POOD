package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Contato;

public class ContatoDao extends GenericDao implements IDao<Contato> {

	private static final String INSERT = "insert into "
			+ "contatos values(?,?,?,?,?,?)";

	private static final String UPDATE = "update contatos "
			+ "set apelido=?, telephone=?, celular=?, email=?, dt_nasc=? "
			+ "where nome=?";

	private static final String DELETE = "delete from "
			+ "contatos where nome=?";

	private static final String SELECT = "select * from "
			+ "contatos where nome=?";

	private static final String FINDALL = "select * from " + "contatos";

	public void save(Contato obj) throws Exception {
		executeSQL(INSERT, obj.getNome(), obj.getApelido(), obj.getTelefone(),
				obj.getCelular(), obj.getEmail(), obj.getDataNascimento());
	}

	public void delete(Contato obj) throws Exception {
		executeSQL(DELETE, obj.getNome());
	}

	public void update(Contato obj) throws Exception {
		executeSQL(UPDATE, obj.getApelido(), obj.getTelefone(),
				obj.getCelular(), obj.getEmail(), obj.getDataNascimento(),
				obj.getNome());
	}

	public Contato find(Contato obj) throws Exception {
		Contato l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getNome());
			if (rs.next()) {
				return l = new Contato(rs.getString("nome"),
						rs.getString("apelido"), rs.getString("telephone"),
						rs.getString("celular"), rs.getString("email"),
						rs.getDate("dt_nasc"));
			}
		} catch (Exception e) {
			throw new Exception("Nome incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Contato> findAll() throws Exception {
		ArrayList<Contato> l = new ArrayList<Contato>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Contato(rs.getString("nome"),
						rs.getString("apelido"), rs.getString("telephone"), rs
								.getString("celular"), rs.getString("email"),
						rs.getDate("dt_nasc")));
			}
		} catch (Exception e) {
			throw new Exception("Não foi possível achar todos os Contatos! "
					+ e.getMessage());
		}
		return l;
	}

}
