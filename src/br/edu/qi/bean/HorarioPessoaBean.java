package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.HorarioPessoaDao;
import br.edu.qi.dto.HorarioPessoa;

@Stateless
@Local
public class HorarioPessoaBean  {
	
	
	public void save(HorarioPessoa obj) throws Exception
	{
		try
		{
			HorarioPessoaDao dao = new HorarioPessoaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public ArrayList<HorarioPessoa> findPorHorario(int idHorario) throws Exception{
		try
		{
			HorarioPessoaDao dao = new HorarioPessoaDao();
			
			return dao.findHorario(idHorario);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public ArrayList<HorarioPessoa> findPorPessoa(int idPessoa) throws Exception{
		try
		{
			HorarioPessoaDao dao = new HorarioPessoaDao();
			
			return dao.findPessoa(idPessoa);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
}
