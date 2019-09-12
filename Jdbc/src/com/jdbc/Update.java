package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://localhost/sakhadb";
		String un="suresh";
		String pw="Suresh@6123";
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		
		try
		{
			
			con=DriverManager.getConnection(url,un,pw);
			System.out.println("connection established sucessfully");
			String s="update employee set salary=? where emp_id=?";
			pstmt=con.prepareStatement(s);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the salary");
			int temp1=sc.nextInt();
			System.out.println("enter the emp_id where salary changed");
			int temp2=sc.nextInt();
			pstmt.setInt(1,temp1);
			pstmt.setInt(2,temp2);
			int x=pstmt.executeUpdate();
			System.out.println(x);
			 res=pstmt.executeQuery("select * from employee");
		    while(res.next())
		    {
		    	System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3)+"\t"+res.getLong(4)+"\t"+res.getInt(5));
		    }
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("some problem occured");
		}

	}

}
