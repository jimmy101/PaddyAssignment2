package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class GetCustomerHistory extends ActionSupport{

	private static final long serialVersionUID = 6446985129361884948L;
	private int id;
	private String userName,name;
	private ArrayList<HistoryBean> historyList;
	private HistoryBean hist;

	public String execute(){
		 String ret = ERROR;
	      Connection conn1 = null;
	  historyList  =  new ArrayList<HistoryBean>();

	      try {
	        
	    	  String URL = "jdbc:mysql://localhost/paddy";
				Class.forName("com.mysql.jdbc.Driver");
				conn1 = DriverManager.getConnection(URL, "root", "root");
				
				PreparedStatement ps221=conn1.prepareStatement("select * from history where name = ?");
				ps221.setString(1, getName());
				ResultSet rs12 = ps221.executeQuery();
				HistoryBean hist = null;
				while(rs12.next()){
					System.out.println("YYYYYYYYYYYYYYYYYYYY"+rs12.getString(3));
					hist= new HistoryBean();
					
					hist.setItem_id(rs12.getInt(1));
					hist.setPurchases_id(rs12.getInt(2));
					hist.setTitle(rs12.getString(3));
					hist.setManufacturer(rs12.getString(4));
					hist.setPrice(rs12.getDouble(5));
					hist.setQuantity(rs12.getInt(6));
					hist.setModifiedTime(rs12.getString(7));
					hist.setId(rs12.getInt(8));
					hist.setName(rs12.getString(9));
					
					historyList.add(hist);
					
				}
									
					//userList.add(ve);
					
					
				
				return SUCCESS;
				
			} catch (Exception e) {
				ret = ERROR;
			} finally {
				if (conn1 != null) {
					try {
						conn1.close();
					} catch (Exception e) {
					}
				}
			}
		
			return ret;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	

	public ArrayList<HistoryBean> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(ArrayList<HistoryBean> historyList) {
		this.historyList = historyList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HistoryBean getHist() {
		return hist;
	}

	public void setHist(HistoryBean hist) {
		this.hist = hist;
	}
	
	
}

