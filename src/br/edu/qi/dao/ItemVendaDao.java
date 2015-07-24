package br.edu.qi.dao;

import java.util.ArrayList;

import br.edu.qi.dto.ItemVenda;

public class ItemVendaDao extends GenericDao implements IDao<ItemVenda> {
	
	private static final String INSERT = "insert into "
			+ "item_venda values(?,?,?,?)";;
			

	public void save(ItemVenda obj) throws Exception {
		executeSQL(INSERT, obj.getIdItem(),obj.getIdVenda(), obj.getQuantidade(),obj.getValor());
	}


	@Override
	public ItemVenda find(ItemVenda obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<?> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
