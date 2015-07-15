package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.UsuarioDao;
import br.edu.qi.dto.Usuario;

@Stateless
@Local
public class UsuarioBean  {
	

	public Usuario find(Usuario obj) throws Exception
	{
		try
		{
			UsuarioDao dao = new UsuarioDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
	
	public ArrayList<Usuario> findAll() throws Exception
	{
		try
		{
			UsuarioDao dao = new UsuarioDao();
			
			return dao.findAll();
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar todos: "+ex.getMessage());
		}
	}
	
	public void save(Usuario obj) throws Exception
	{
		try
		{
			UsuarioDao dao = new UsuarioDao();
			
			dao.save(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao salvar: "+ex.getMessage());
		}
	}
	
}
