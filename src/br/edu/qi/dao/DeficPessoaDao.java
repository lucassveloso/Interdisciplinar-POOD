package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.DeficPessoa;
import br.edu.qi.dto.Deficiencia;

public class DeficPessoaDao extends GenericDao implements IDao<DeficPessoa> {
	
	private static final String INSERT = "insert into "
			+ "defic_pessoas values(?,?)";;
			

	public void save(DeficPessoa obj) throws Exception {
		executeSQL(INSERT, obj.getIdPessoa(), obj.getIdDeficiencia());
	}


	@Override
	public DeficPessoa find(DeficPessoa obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<?> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
