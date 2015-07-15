package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.HorarioDao;
import br.edu.qi.dto.Horario;

@Stateless
@Local
public class HorarioBean  {
	

	public Horario find(Horario obj) throws Exception
	{
		try
		{
			HorarioDao dao = new HorarioDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Horario> findAll() throws Exception
	{
		try
		{
			HorarioDao dao = new HorarioDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Horario obj) throws Exception
	{
		try
		{
			HorarioDao dao = new HorarioDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
