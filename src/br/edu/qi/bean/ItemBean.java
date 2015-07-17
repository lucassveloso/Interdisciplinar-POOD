package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ItemDao;
import br.edu.qi.dao.VendaDao;
import br.edu.qi.dto.Item;
import br.edu.qi.dto.Venda;

@Stateless
@Local
public class ItemBean  {
	

	public Item find(Item obj) throws Exception
	{
		try
		{
			ItemDao dao = new ItemDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public Item find(int id) throws Exception
	{
		try
		{
			ItemDao dao = new ItemDao();
			Item obj = new Item();
			obj.setIdItem(id);
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Item> findAll() throws Exception
	{
		try
		{
			ItemDao dao = new ItemDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public ArrayList<Item> findProdutos() throws Exception
	{
		try
		{
			ItemDao dao = new ItemDao();
			
			return dao.findProdutos();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public Item save(Item obj) throws Exception
	{
		try
		{
			ItemDao dao = new ItemDao();
			
			return dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
