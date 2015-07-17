package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ProdutoDao;
import br.edu.qi.dto.Produto;

@Stateless
@Local
public class ProdutoBean  {
	

	public Produto find(Produto obj) throws Exception
	{
		try
		{
			ProdutoDao dao = new ProdutoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public Produto find(int id) throws Exception
	{
		try
		{
			ProdutoDao dao = new ProdutoDao();
			
			return dao.find(id);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Produto> findAll() throws Exception
	{
		try
		{
			ProdutoDao dao = new ProdutoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Produto obj) throws Exception
	{
		try
		{
			ProdutoDao dao = new ProdutoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
