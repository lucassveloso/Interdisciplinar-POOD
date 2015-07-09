package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ReligiaoDao;
import br.edu.qi.dto.Religiao;

@Stateless
@Local
public class ReligiaoBean  {
	

	public Religiao find(Religiao obj) throws Exception
	{
		try
		{
			ReligiaoDao dao = new ReligiaoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Religiao> findAll() throws Exception
	{
		try
		{
			ReligiaoDao dao = new ReligiaoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	

	
}
