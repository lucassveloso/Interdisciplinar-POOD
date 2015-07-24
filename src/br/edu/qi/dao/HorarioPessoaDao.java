package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.HorarioPessoa;

public class HorarioPessoaDao extends GenericDao implements IDao<HorarioPessoa> {

	private static final String INSERT = "insert into "
			+ "horario_pessoas values(?,?)";

	private static final String SELECTPESSOA = "select * from "
			+ "horario_pessoas where Id_pessoa=?";

	private static final String SELECTHORARIO = "select * from "
			+ "horario_pessoas where Id_horario=?";
	
	private static final String FINDALL = "select * from horario_pessoas";

	public void save(HorarioPessoa obj) throws Exception {
		executeSQL(INSERT, obj.getIdPessoa(), obj.getIdHorario());
	}

	public ArrayList<HorarioPessoa> findPessoa(int id) throws Exception {
		ArrayList<HorarioPessoa> l = new ArrayList<HorarioPessoa>();
		try {
			ResultSet rs = executeQuery(SELECTPESSOA, id);
			while (rs.next()) {
				l.add(new HorarioPessoa(rs.getInt("Id_pessoa"),rs.getInt("Id_horario")));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}
	
	public ArrayList<HorarioPessoa> findHorario(int id) throws Exception {
		ArrayList<HorarioPessoa> l = new ArrayList<HorarioPessoa>();
		try {
			ResultSet rs = executeQuery(SELECTHORARIO, id);
			while  (rs.next()) {
				l.add(new HorarioPessoa(rs.getInt("Id_pessoa"),rs.getInt("Id_horario")));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<HorarioPessoa> findAll() throws Exception {
		ArrayList<HorarioPessoa> l = new ArrayList<HorarioPessoa>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new HorarioPessoa(rs.getInt("Id_pessoa"),rs.getInt("Id_horario")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as HorarioPessoa! "
							+ e.getMessage());
		}
		return l;
	}

	@Override
	public HorarioPessoa find(HorarioPessoa obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
