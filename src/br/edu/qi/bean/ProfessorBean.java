package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ProfessorDao;
import br.edu.qi.dto.Professor;

@Stateless
@Local
public class ProfessorBean  {
	

	public Professor find(Professor obj) throws Exception
	{
		try
		{
			ProfessorDao dao = new ProfessorDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Professor> findAll() throws Exception
	{
		try
		{
			ProfessorDao dao = new ProfessorDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Professor obj) throws Exception
	{
		try
		{
			ProfessorDao dao = new ProfessorDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
