package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.EtniaDao;

import br.edu.qi.dto.Etnia;

@Stateless
@Local
public class EtniaBean  {
	

	public Etnia find(Etnia obj) throws Exception
	{
		try
		{
			EtniaDao dao = new EtniaDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Etnia> findAll() throws Exception
	{
		try
		{
			EtniaDao dao = new EtniaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	
}
