package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.PessoaDao;
import br.edu.qi.dto.Pessoa;

@Stateless
@Local
public class PessoaBean  {
	

	public Pessoa find(Pessoa obj) throws Exception
	{
		try
		{
			PessoaDao dao = new PessoaDao();
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public Pessoa findSemId(Pessoa obj) throws Exception
	{
		try
		{
			PessoaDao dao = new PessoaDao();
			return dao.findSemId(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Pessoa> findAll() throws Exception
	{
		try
		{
			PessoaDao dao = new PessoaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Pessoa obj) throws Exception
	{
		try
		{
			PessoaDao dao = new PessoaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}


	
}
