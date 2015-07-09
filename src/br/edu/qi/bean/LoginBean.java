package br.edu.qi.bean;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.LoginDao;
import br.edu.qi.dto.Login;

@Stateless
@Local
public class LoginBean  {
	
	
	public Login find(Login obj) throws Exception
	{
		try
		{
			LoginDao dao = new LoginDao();
			
			return dao.find(obj);
		}catch(Exception ex)
		{
			throw new Exception("Erro ao procurar: "+ex.getMessage());
		}
	}
}
