package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.DeficienciaDao;
import br.edu.qi.dto.Deficiencia;

@Stateless
@Local
public class DeficienciaBean  {
	

	public Deficiencia find(Deficiencia obj) throws Exception
	{
		try
		{
			DeficienciaDao dao = new DeficienciaDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Deficiencia> findAll() throws Exception
	{
		try
		{
			DeficienciaDao dao = new DeficienciaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Deficiencia obj) throws Exception
	{
		try
		{
			DeficienciaDao dao = new DeficienciaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
