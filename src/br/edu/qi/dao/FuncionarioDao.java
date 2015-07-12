package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Funcionario;

public class FuncionarioDao extends GenericDao implements IDao<Funcionario> {

	private static final String INSERT = "insert into "
			+ "Funcionarios values(?,?,?)";

	private static final String SELECT = "select * from "
			+ "Funcionarios where Id_pessoa=?";

	private static final String FINDALL = "select * from Funcionarios";

	public void save(Funcionario obj) throws Exception {
		executeSQL(INSERT,obj.getIdPessoa(),obj.getDtAdmissao(),obj.getCargo());
	}

	public Funcionario find(Funcionario obj) throws Exception {
		Funcionario l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdPessoa());
			if (rs.next()) {
				return l = new Funcionario(
						rs.getInt("Id_pessoa"),
						rs.getDate("Dt_adimissao"),
						rs.getString("cargo"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Funcionario> findAll() throws Exception {
		ArrayList<Funcionario> l = new ArrayList<Funcionario>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add( new Funcionario(
						rs.getInt("Id_pessoa"),
						rs.getDate("Dt_adimissao"),
						rs.getString("cargo")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Funcionarios! "
							+ e.getMessage());
		}
		return l;
	}



}
