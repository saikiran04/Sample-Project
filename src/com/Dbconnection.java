package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
	
	public static Connection createConnection()
	 {
	 Connection con = null;
	 String url = "jdbc:h2:tcp://localhost/~/test"; //H2 URL and followed by the database name
	 String username = "sa"; //H2 username
	 String password = ""; //H2 password
	 
	 try 
	 {
	 
	 Class.forName("org.h2.Driver"); //loading h2 driver 
	 
	 con = DriverManager.getConnection(url, username, password); //attempting to connect to h2 database
	 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 return con; 
	 }

}
