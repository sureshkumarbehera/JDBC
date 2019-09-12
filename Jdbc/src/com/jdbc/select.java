package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class select {

	public static void main(String[] args) {
		
      String url="jdbc:mysql://localhost/sakhadb";
      String un="suresh";
      String pw="Suresh@6123";
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet res=null;
      
      
      try
      {
    	Class.forName("com.mysql.jdbc.Driver");
    	System.out.println("Driver loaded sucessfully");
    	con=DriverManager.getConnection(url,un,pw);
    	System.out.println("connection established sucessfully");
    	String s="select * from employee where emp_id =?";
    	pstmt=con.prepareStatement(s);
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("enter the emp_id");
    	int temp=sc.nextInt();
    	pstmt.setInt(1, temp);
    	res=pstmt.executeQuery();
    	while(res.next()==true)
    	{
          int a=res.getInt(1);
          String b=res.getString(2);
          int c=res.getInt(3);
          long d=res.getLong(4);
          int e=res.getInt(5);
          System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e);
    		
    	}
    	  
      }
      catch(Exception e)
      {
    	  e.printStackTrace();
    	  System.out.println("some problem occured");
      }
	}

}
