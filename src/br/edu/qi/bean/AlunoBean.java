package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.AlunoDao;
import br.edu.qi.dto.Aluno;

@Stateless
@Local
public class AlunoBean  {
	

	public Aluno find(Aluno obj) throws Exception
	{
		try
		{
			AlunoDao dao = new AlunoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Aluno> findAll() throws Exception
	{
		try
		{
			AlunoDao dao = new AlunoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Aluno obj) throws Exception
	{
		try
		{
			AlunoDao dao = new AlunoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
