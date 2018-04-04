package org.aashay.spit.MS_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class MySqlClass {
	
	public ResultSet retrieveFromDatabase()
	{
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MS_project","root","root");    
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from stocks natural join price");  
			return rs;
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}
		return null;
	}
	public int updateDatabase(Stock stock)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MS_project","root","root");    
			Statement stmt=con.createStatement(); 
			checkIsin(stmt,stock);
			return stmt.executeUpdate("Insert into price values('"+stock.getStockName()+"','"+stock.getDate()+"',"+stock.getTime6am()+","+stock.getTime12pm()+","+stock.getTime6pm()+")");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return -1;
	}
	private void checkIsin(Statement stmt, Stock stock) {
		// TODO Auto-generated method stub
		try
		{
			ResultSet rs=stmt.executeQuery("select * from stocks");
			HashMap<String,String> isinMap=new HashMap<>();
			System.out.println("Hello1");
			while(rs.next())
				isinMap.put(rs.getString(1),rs.getString(2));
			System.out.println(stock.getIsin()+"   "+stock.getStockName());
			if(!isinMap.containsKey(stock.getIsin().toUpperCase()) && !isinMap.containsValue(stock.getStockName()))
				stmt.executeUpdate("Insert into stocks values('"+stock.getIsin()+"','"+stock.getStockName()+"')");
			System.out.println("Hello");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
