package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.CursoDao;
import br.edu.qi.dto.Curso;

@Stateless
@Local
public class CursoBean  {
	

	public Curso find(Curso obj) throws Exception
	{
		try
		{
			CursoDao dao = new CursoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Curso> findAll() throws Exception
	{
		try
		{
			CursoDao dao = new CursoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Curso obj) throws Exception
	{
		try
		{
			CursoDao dao = new CursoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
