package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.HorarioPessoaDao;
import br.edu.qi.dao.HorarioTurmaDao;
import br.edu.qi.dto.HorarioPessoa;
import br.edu.qi.dto.HorarioTurma;

@Stateless
@Local
public class HorarioTurmaBean  {
	
	
	public void save(HorarioTurma obj) throws Exception
	{
		try
		{
			HorarioTurmaDao dao = new HorarioTurmaDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
	public HorarioTurma findPorTurma(int id) throws Exception{
		try
		{
			HorarioTurmaDao dao = new HorarioTurmaDao();
			
			return dao.findTurma(id);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}

}
