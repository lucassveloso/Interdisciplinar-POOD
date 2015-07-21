package br.edu.qi.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.qi.dto.Pessoa;
import br.edu.qi.dto.Venda;

public class VendaDao extends GenericDao  {

	private static final String INSERT = "insert into "
			+ "Vendas(id_Pessoa,valor_total) values(?,?)";

	private static final String SELECT = "select * from "
			+ "Vendas where Id_Venda=?";

	private static final String FINDALL = "select * from Vendas";

	public Venda save(Venda obj) throws Exception {
		executeSQL(INSERT, obj.getIdPessoa(),obj.getValorTotal());
		
		ArrayList<Venda> Venda = findAll();
		for (Venda venda2 : Venda) {
			System.out.println("IDFINDA: "+venda2.getIdVenda());
		}
		return Venda.get(Venda.size()-1);
	}

	public Venda find(Venda obj) throws Exception {
		Venda l = null;
		try {
			ResultSet rs = executeQuery(SELECT, obj.getIdVenda());
			if (rs.next()) {
				return l = new Venda(
						rs.getInt("Id_Venda"),
						rs.getInt("Id_Pessoa"),
						rs.getFloat("valor_total"));
			}
		} catch (Exception e) {
			throw new Exception("Id incorreto! " + e.getMessage());
		}
		return l;
	}

	public ArrayList<Venda> findAll() throws Exception {
		ArrayList<Venda> l = new ArrayList<Venda>();
		try {
			ResultSet rs = executeQuery(FINDALL);
			while (rs.next()) {
				l.add(new Venda(
						rs.getInt("Id_Venda"),
						rs.getInt("Id_Pessoa"),
						rs.getFloat("valor_total")));
			}
		} catch (Exception e) {
			throw new Exception(
					"Não foi possível achar todos as Vendas! "
							+ e.getMessage());
		}
		return l;
	}
	

}
