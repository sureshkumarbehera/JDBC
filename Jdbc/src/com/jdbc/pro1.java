package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class pro1 {

	public static void main(String[] args) throws Exception{
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sakhadb","suresh","Suresh@6123");
	    Statement stmt=con.createStatement();
	    ResultSet res=stmt.executeQuery("select * from emp");
	    while(res.next())
	    {
	    	System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3)+"\t"+res.getLong(4)+"\t"+res.getInt(5));
	    }

	}

}
