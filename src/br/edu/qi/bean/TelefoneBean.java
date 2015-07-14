package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.TelefoneDao;
import br.edu.qi.dto.Telefone;

@Stateless
@Local
public class TelefoneBean  {
	
	
	public void save(Telefone obj) throws Exception
	{
		try
		{
			TelefoneDao dao = new TelefoneDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
