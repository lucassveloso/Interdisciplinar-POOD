package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.SexoDao;

import br.edu.qi.dto.Sexo;

@Stateless
@Local
public class SexoBean  {
	

	public Sexo find(Sexo obj) throws Exception
	{
		try
		{
			SexoDao dao = new SexoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Sexo> findAll() throws Exception
	{
		System.out.println("to no bean");
		try
		{
			SexoDao dao = new SexoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	
}
