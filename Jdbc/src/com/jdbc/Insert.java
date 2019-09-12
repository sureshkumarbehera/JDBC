package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Insert {

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
			String s="insert into employee values (?,?,?,?,?)";
			pstmt=con.prepareStatement(s);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the employee id ");
			int temp1=sc.nextInt();
			System.out.println("Enter the employee name");
			String temp2=sc.next();
			System.out.println("Enter the employee salary");
			int temp3=sc.nextInt();
			System.out.println("Enter the employee phone number");
			long temp4=sc.nextLong();
			System.out.println("Enter the employee department number");
			int temp5=sc.nextInt();
			pstmt.setInt(1,temp1);
			pstmt.setString(2,temp2);
			pstmt.setInt(3, temp3);
			pstmt.setLong(4, temp4);
			pstmt.setInt(5, temp5);
			
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
