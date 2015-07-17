package br.edu.qi.bean;

import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.edu.qi.dao.PessoaDao;
import br.edu.qi.dto.Pessoa;

@Stateless
@Local
public class PessoaBean {

	public Pessoa find(Pessoa obj) throws Exception {
		try {
			PessoaDao dao = new PessoaDao();
			return dao.find(obj);
		} catch (Exception ex) {
			throw new Exception("Erro ao procurar: " + ex.getMessage());
		}
	}

	public Pessoa find(int id) throws Exception {
		try {
			PessoaDao dao = new PessoaDao();
			return dao.find(id);
		} catch (Exception ex) {
			throw new Exception("Erro ao procurar: " + ex.getMessage());
		}
	}

	public ArrayList<Pessoa> findAll(String tipo) throws Exception {
		try {
			PessoaDao dao = new PessoaDao();

			if (tipo.equals("aluno")) {
				return dao.findAlunos();
			} else if (tipo.equals("professor")) {
				return dao.findProfessores();
			}
			if (tipo.equals("funcionario")) {
				return dao.findFuncionarios();
			}
			return dao.findAll();
		} catch (Exception ex) {
			throw new Exception("Erro ao procurar todos: " + ex.getMessage());
		}
	}

	public Pessoa save(Pessoa obj) throws Exception {
		try {
			PessoaDao dao = new PessoaDao();

			return dao.save(obj);
		} catch (Exception ex) {
			throw new Exception("Erro ao salvar: " + ex.getMessage());
		}
	}

}
