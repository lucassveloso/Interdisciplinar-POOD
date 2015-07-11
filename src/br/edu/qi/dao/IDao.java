package br.edu.qi.dao;

import java.util.ArrayList;

public interface IDao<T> {
	public void save(T obj) throws Exception;
	public T find(T obj) throws Exception;
	public ArrayList<?> findAll() throws Exception; 

}
