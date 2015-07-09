package br.edu.qi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionManager {

	private static ConnectionManager connMg;
	private static ResourceBundle config;
	
	private ConnectionManager() {
		config= ResourceBundle.getBundle("config");
	}
	public static ConnectionManager getInstance()
	{
		if (connMg==null)
			connMg=new ConnectionManager();
		
		return connMg;
	}
	public void closeAll() throws Exception
	{
		if (getInstance().getConnection()!=null)
			getInstance().getConnection().close();
		
	}
	public Connection getConnection() throws Exception
	{
		Class.forName(config.getString("br.edu.qi.Driver"));
		
		return DriverManager.getConnection(
				config.getString("br.edu.qi.url"), 
				config.getString("br.edu.qi.user"),
				config.getString("br.edu.qi.pwd"));
	}
}
