package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ItemVendaDao;
import br.edu.qi.dto.ItemVenda;

@Stateless
@Local
public class ItemVendaBean  {
	
	
	public void save(ItemVenda obj) throws Exception
	{
		try
		{
			ItemVendaDao dao = new ItemVendaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
