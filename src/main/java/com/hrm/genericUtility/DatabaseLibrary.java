package com.hrm.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to fetch data from database.
 * @author daniel
 *
 */
public class DatabaseLibrary {
	Driver dbDriver;
	Connection connection;
	
/**
 * This method is used to get the connection to the database
 * @param dbURL
 * @param dbUserName
 * @param dbPassword
 */
	public void connectionToDatabase(String dbURL, String dbUserName, String dbPassword) {
		try {
			dbDriver=new Driver();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			DriverManager.registerDriver(dbDriver);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to fetch the data from the database.
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getdataFromDatabase(String query,String columnName){
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet result = null;
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> list=new ArrayList<String>();
		try {
			while(result.next()) {
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * This method is used to update the data in database by using query
	 * @param query
	 * @param columnName
	 * @param expectedData
	 */
	public void updateDatabase(String query,String columnName,String expectedData) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to execute and verify the data in the database
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 */
	public boolean executeAndVerifyDatabase(String query,String columnName,String expectedData) {
		List<String> list=getdataFromDatabase(query,columnName);
		boolean flag=false;
		for(String actualData: list) {
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
		}
		 if(list.contains(expectedData))flag=true;
		 return flag;
	}
	
	/**
	 * This method is used to close the database connection
	 */
	public void closeDatabase() {
	 try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

