package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delect {

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
			System.out.println("Connection established sucessfully");
			String s="delete from department where dept_no=?";
			pstmt=con.prepareStatement(s);
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the department number where delect the details");
			int temp1=sc.nextInt();
			
			pstmt.setInt(1, temp1);
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
