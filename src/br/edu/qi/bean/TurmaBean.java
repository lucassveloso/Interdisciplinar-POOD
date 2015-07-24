package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ProdutoDao;
import br.edu.qi.dao.TurmaDao;
import br.edu.qi.dto.Turma;

@Stateless
@Local
public class TurmaBean  {
	

	public Turma find(Turma obj) throws Exception
	{
		try
		{
			TurmaDao dao = new TurmaDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Turma> findAll() throws Exception
	{
		try
		{
			TurmaDao dao = new TurmaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public Turma save(Turma obj) throws Exception
	{
		try
		{
			TurmaDao dao = new TurmaDao();
			
			return dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
		
	}
	
	public void updateCapacidade(int capacidade, int id) throws Exception
	{
		try
		{
			TurmaDao dao = new TurmaDao();
			
			dao.UpdateCapacidade(capacidade, id);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
