package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.TipoFiliacaoDao;
import br.edu.qi.dto.TipoFiliacao;

@Stateless
@Local
public class TipoFiliacaoBean  {
	

	public TipoFiliacao find(TipoFiliacao obj) throws Exception
	{
		try
		{
			TipoFiliacaoDao dao = new TipoFiliacaoDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<TipoFiliacao> findAll() throws Exception
	{
		try
		{
			TipoFiliacaoDao dao = new TipoFiliacaoDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	

	
}
