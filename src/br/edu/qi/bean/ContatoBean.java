package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ContatoDao;
import br.edu.qi.dto.Contato;

@Stateless
@Local
public class ContatoBean  {
	

	public Contato find(Contato obj) throws Exception
	{
		try
		{
			ContatoDao dao = new ContatoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Contato> findAll() throws Exception
	{
		try
		{
			ContatoDao dao = new ContatoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Contato obj) throws Exception
	{
		try
		{
			ContatoDao dao = new ContatoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public void update(Contato obj) throws Exception
	{
		try
		{
			ContatoDao dao = new ContatoDao();
			
			dao.update(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public void delete(Contato obj) throws Exception
	{
		try
		{
			ContatoDao dao = new ContatoDao();
			
			dao.delete(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao deletar: "+ex.getMessage());
		}
	}
}
