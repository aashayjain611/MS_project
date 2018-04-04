package org.aashay.spit.MS_project;

public class Stock {

	private String stockName;
	private String date;
	private int time6am;
	private int time12pm;
	private int time6pm;
	private String isin;
	
	public Stock(String stockName, String isin, String date, int time6am, int time12pm, int time6pm) {
		super();
		this.stockName = stockName;
		this.date = date;
		this.time6am = time6am;
		this.time12pm = time12pm;
		this.time6pm = time6pm;
		this.isin=isin;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime6am() {
		return time6am;
	}

	public void setTime6am(int time6am) {
		this.time6am = time6am;
	}

	public int getTime12pm() {
		return time12pm;
	}

	public void setTime12pm(int time12pm) {
		this.time12pm = time12pm;
	}

	public int getTime6pm() {
		return time6pm;
	}

	public void setTime6pm(int time6pm) {
		this.time6pm = time6pm;
	}
	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}
}
