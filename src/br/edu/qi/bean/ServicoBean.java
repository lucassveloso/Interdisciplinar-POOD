package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ServicoDao;
import br.edu.qi.dto.Servico;

@Stateless
@Local
public class ServicoBean  {
	

	public Servico find(Servico obj) throws Exception
	{
		try
		{
			ServicoDao dao = new ServicoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Servico> findAll() throws Exception
	{
		try
		{
			ServicoDao dao = new ServicoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Servico obj) throws Exception
	{
		try
		{
			ServicoDao dao = new ServicoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
