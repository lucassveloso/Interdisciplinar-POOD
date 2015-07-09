package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.DeficPessoaDao;
import br.edu.qi.dto.DeficPessoa;

@Stateless
@Local
public class DeficPessoaBean  {
	
	
	public void save(DeficPessoa obj) throws Exception
	{
		try
		{
			DeficPessoaDao dao = new DeficPessoaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
