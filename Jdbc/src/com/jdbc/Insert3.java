package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Insert3 {

	public static void main(String[] args) {
		
		
		String url="jdbc:mysql://localhost/sakhadb";
		String un="suresh";
		String pw="Suresh@6123";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		try
		{
			con=DriverManager.getConnection(url,un,pw);
			System.out.println("Connection established sucessully");
			String s="insert into employee values (385,'sukanti',34000,8675888953,5)";
			pstmt=con.prepareStatement(s);
			
			int x=pstmt.executeUpdate();
			System.out.println(x);
					
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("some problem occured");
		}

	}

}
