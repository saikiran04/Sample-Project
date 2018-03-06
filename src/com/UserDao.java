package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

public class UserDao {
	
	 public static String authenticateUser(User user)
	 {
	 
	String userName = user.getUsername(); //Keeping user entered values in temporary variables.
	 String password = user.getPassword();
	 
	Connection con ;
	 Statement statement;
	 ResultSet resultSet ;
	  
	 try
	 {
	 con = Dbconnection.createConnection(); //establishing connection
	 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
	 resultSet = statement.executeQuery("select username,password from user"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
	 
	while(resultSet.next()) // Until next row is present otherwise it return false
	 {
		String userNameDB = resultSet.getString("userName"); //fetch the values present in database
		String passwordDB = resultSet.getString("password");
	 
	   if(userName.equals(userNameDB) && password.equals(passwordDB))
	   {
	      return "SUCCESS"; //If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
	   }
	 }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "error"; // Just returning appropriate message otherwise
	 }
	 
	 public static String passValidate(User user)
	 {
	 
	String uname = user.getUsername(); //Keeping user entered values in temporary variables.
	 String password = user.getPassword();
	 
	Connection con ;
	 Statement statement;
	 int resultSet ;
	  
	 try
	 {
	 con = Dbconnection.createConnection(); //establishing connection
	 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
	 
	 resultSet = statement.executeUpdate("update user set Password='"+password+"' where Username='"+uname+"'"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
	 
	
	  
	      return "success"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
	   
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 return "Invalid user credentials"; // Just returning appropriate message otherwise
	 }
	 
	 
	 public static Student getDetails(Student student) {
		//name = null;
		 int rollno = 0;
		String name= student.getStudentname();
	
		 Connection con ;
		// Statement statement;
		 ResultSet resultSet ;
		try
		 {
		 con = Dbconnection.createConnection(); //establishing connection	
		 String nsql = null;
		 String rsql = null;
		 PreparedStatement ps;
		boolean flag=false;		
		try {
			   Integer.parseInt(name);
			   // s is a valid integer!
			   flag = true;
			  } catch (NumberFormatException e) {
				  flag = false;
			  }
		
		
		 if(flag) {
			int rollno1=Integer.parseInt(name);
		 rsql="select * from student where rollnumber=?";
		 ps  = con.prepareStatement(rsql);
		 ps.setInt(1, rollno1);	
		 resultSet=ps.executeQuery();	
		 flag = false;
		 }else {
			  nsql="select * from student where name=?";
			   ps = con.prepareStatement(nsql);			  	 
			  ps.setString(1,name);
			  resultSet=ps.executeQuery();
		}
			 
	
		 
		 while(resultSet.next()) {
			 int rollno1=resultSet.getInt("rollnumber");
			 String sname=resultSet.getString("name");
			 String gender=resultSet.getString("gender");
			 int grade=resultSet.getInt("grade");
			 student.setStudentname(sname);
			
			 student.setRollnumber(rollno1);
			 student.setGender(gender);
			 student.setGrade(grade);
			 System.out.println(gender);
			 System.out.println(student.getGender());
		 }
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 
		return student;
	 }
	 
	 public static String save(Student student) {
		 
	 
		 Connection con ;
		 Statement statement;
		 int resultSet ;
		 try
		 {
		 con = Dbconnection.createConnection(); //establishing connection
		 String sql="insert into student (rollnumber,name,gender,grade) values(?,?,?,?)";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setInt(1, student.getRollnumber() );
		 ps.setString(2, student.getStudentname());
		 ps.setString(3, student.getGender());
		 ps.setInt(4, student.getGrade());
		 resultSet=ps.executeUpdate();
		 
		 return "success";
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return "Invalid user credentials";
	 }
	 
	 public static String savemarks(Marks marks) {
		 
		 
		 Connection con ;
		 Statement statement;
		 int resultSet ;
		 try
		 {
		 con = Dbconnection.createConnection(); //establishing connection
		 String sql="insert into marks (rollnumber,english,maths,science) values(?,?,?,?)";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setInt(1, marks.getRollnumber());
		 ps.setInt(2, marks.getEnglish());
		 ps.setInt(3, marks.getMaths());
		 ps.setInt(4, marks.getScience());
	
		 resultSet=ps.executeUpdate();
		 
		 return "success";
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return "Invalid user credentials";
	 }
	 
	 public static Marks getMarksDetails(Marks marks) {
		 int roll=marks.getRollnumber();
		 Connection con ;
		 Statement statement;
		 ResultSet resultSet ;
		 try
		 {
		 con = Dbconnection.createConnection(); //establishing connection
		 String sql="select * from marks where rollnumber=?";
		 PreparedStatement ps = con.prepareStatement(sql);
		 ps.setInt(1, roll );
		
		 resultSet=ps.executeQuery();
		 while(resultSet.next()) {
			 int rollno=resultSet.getInt("rollnumber");
			 int eng=resultSet.getInt("english");
			 int math=resultSet.getInt("maths");
			 int sci=resultSet.getInt("science");
			 //marks.setRollnumber(rollno);
			 marks.setEnglish(eng);
			 marks.setMaths(math);
			 marks.setScience(sci);
			 System.out.println(math);
			 System.out.println(marks.getMaths());
		 }
		 
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return marks;
	 }
	 
	 
	 public static String processFile(Student student) throws SQLException, NumberFormatException, IOException {
		MultipartFile file;
		file=student.getFile();
		String nfile=file.getOriginalFilename();
		 File newFile = new File("C:\\Users\\Saikiran.Ammakolla\\eclipse-workspace2\\Student\\WebContent\\WEB-INF\\folder\\" + nfile);  
		 newFile.createNewFile();  
		 file.transferTo(newFile);
		 Connection con ;
		 Statement statement;
		 ResultSet resultSet ;
		 con = Dbconnection.createConnection();
		 String sql="insert into student (rollnumber,name,gender,grade) values(?,?,?,?)";
		 String[] array = null;
		 CSVReader csvReader = new CSVReader(new FileReader(newFile));
		 List content = csvReader.readAll();

		 for (Object object : content) {
		 	array = (String[]) object;
		 	
		 
		 /*	 
		 BufferedReader bReader = new BufferedReader(new FileReader(newFile));
	        String line = ""; 
	        System.out.println(newFile);
	        while ((line = bReader.readLine()) != null) {
	            if (line != null) 
				{
				    String[] array = line.split(",");
				    for(String result:array)
				    {
				    	System.out.println(result);  
				    
				    System.out.println(">>>>>>>>>>>>>>"+array[0]);*/
 PreparedStatement ps = con.prepareStatement(sql);
 ps.setInt(1, Integer.parseInt(array[0]));
       ps.setString(2, array[1]);
       ps.setString(3, array[2]);
       ps.setInt(4, Integer.parseInt(array[3]));
       ps.executeUpdate();
       ps.close();
System.out.println(sql);
				    }
			/*	}
	        }*/
	        return "Success";
}
}


