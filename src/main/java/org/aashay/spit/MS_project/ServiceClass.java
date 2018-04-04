package org.aashay.spit.MS_project;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
public class ServiceClass {
	
	private ResultSet resultSet;
	private List<Stock> list=new ArrayList<>();
	private MySqlClass sql=new MySqlClass();
	
	@GET
	public List<Stock> getStocks()
	{
		resultSet=sql.retrieveFromDatabase();
		try
		{
			
			while(resultSet.next())
				list.add(new Stock(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6)));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public int postStocks(Stock stock)
	{
		return sql.updateDatabase(stock);
		//return getStocks();
	}
}
