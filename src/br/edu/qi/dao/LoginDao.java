package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Login;

public class LoginDao extends GenericDao
		implements IDao<Login>
{

	private static final String INSERT="insert into " +
			"usuarios values(?,?)";
	
	private static final String SELECT="select * from " +
			"usuarios where cd_usuario=? and senha=?";
	
	private static final String FINDALL="select * from " +
			"usuarios";
	
	public void save(Login obj) throws Exception {
		executeSQL(INSERT, obj.getUsuario(),
				obj.getSenha());
	}

	
	public void delete(Login obj) throws Exception {
		
	}

	
	public Login find(Login obj) throws Exception {
		Login l = null;
        try {
            ResultSet rs = executeQuery(SELECT, obj.getUsuario(), obj.getSenha());
            if (rs.next()) {
                return l = new Login(rs.getString("cd_usuario"), rs.getString("senha"));
            }
        } catch (Exception e) {
            throw new Exception("Usuário ou senha incorreto! "+e.getMessage());
        }
        return l;
	}

	
	public ArrayList<Login> findAll() throws Exception {
		ArrayList<Login> l = new ArrayList<Login>();
        try {
            ResultSet rs = executeQuery(FINDALL);
            while (rs.next()) {
                l.add(new Login(rs.getString("cd_usuario"), rs.getString("senha")));
            }
        } catch (Exception e) {
            throw new Exception("Não foi possível achar todos os Usuários! "+e.getMessage());
        }
        return l;
	}

	
}
