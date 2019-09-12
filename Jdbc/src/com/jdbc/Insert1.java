package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Insert1 {

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
			String s="insert into department values (?,?,?)";
			pstmt=con.prepareStatement(s);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the department number ");
			int temp1=sc.nextInt();
			System.out.println("Enter the department name");
			String temp2=sc.next();
			System.out.println("Enter the department location");
			String temp3=sc.next();
			pstmt.setInt(1,temp1);
			pstmt.setString(2,temp2);
			pstmt.setString(3,temp3);
			
			int x=pstmt.executeUpdate();
			System.out.println(x);
					
			res=pstmt.executeQuery("select * from department");
			while(res.next()==true)
			{
				System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("some problem occured");
		}

	}

}
