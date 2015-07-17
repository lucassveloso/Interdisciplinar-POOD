package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.VendaDao;
import br.edu.qi.dto.Venda;

@Stateless
@Local
public class VendaBean  {
	

	public Venda find(Venda obj) throws Exception
	{
		try
		{
			VendaDao dao = new VendaDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Venda> findAll() throws Exception
	{
		try
		{
			VendaDao dao = new VendaDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	
	
	public Venda save(Venda obj) throws Exception
	{
		try
		{
			VendaDao dao = new VendaDao();
			
			return dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
