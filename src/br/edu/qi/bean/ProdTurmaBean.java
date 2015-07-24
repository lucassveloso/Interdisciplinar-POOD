package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.ProdTurmaDao;
import br.edu.qi.dto.ProdTurma;

@Stateless
@Local
public class ProdTurmaBean  {
	
	
	public void save(ProdTurma obj) throws Exception
	{
		try
		{
			ProdTurmaDao dao = new ProdTurmaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
