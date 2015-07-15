package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.FuncionarioDao;
import br.edu.qi.dto.Funcionario;

@Stateless
@Local
public class FuncionarioBean  {
	

	public Funcionario find(Funcionario obj) throws Exception
	{
		try
		{
			FuncionarioDao dao = new FuncionarioDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Funcionario> findAll() throws Exception
	{
		try
		{
			FuncionarioDao dao = new FuncionarioDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Funcionario obj) throws Exception
	{
		try
		{
			FuncionarioDao dao = new FuncionarioDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
