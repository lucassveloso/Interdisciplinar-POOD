package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.MatriculaDao;
import br.edu.qi.dto.Matricula;

@Stateless
@Local
public class MatriculaBean  {
	
	
	public void save(Matricula obj) throws Exception
	{
		try
		{
			MatriculaDao dao = new MatriculaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Matricula> findPorTurma(int id) throws Exception{
		try
		{
			MatriculaDao dao = new MatriculaDao();
			
			return dao.findPorTurma(id);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Matricula> findPorPessoa(int idPessoa) throws Exception{
		try
		{
			MatriculaDao dao = new MatriculaDao();
			
			return dao.findPorPessoa(idPessoa);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Matricula> findAll() throws Exception{
		try
		{
			MatriculaDao dao = new MatriculaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
}
