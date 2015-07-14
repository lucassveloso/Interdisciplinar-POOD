package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.FiliacaoDao;
import br.edu.qi.dto.Filiacao;

@Stateless
@Local
public class FiliacaoBean  {
	
	
	public void save(Filiacao obj) throws Exception
	{
		try
		{
			FiliacaoDao dao = new FiliacaoDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
