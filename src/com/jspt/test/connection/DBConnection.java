package com.jspt.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection con;
	
	public static void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.mariadb.jdbc.Driver");
		String url = "jdbc:mariadb://bdi.c3fxyzwskkss.ap-northeast-2.rds.amazonaws.com:3306/bdi";
		String id = "Abathur";
		String pwd = "dkskzhsek1";
		
		con = DriverManager.getConnection(url, id, pwd);
	}
	
	public static Connection openCon() {
		if(con==null) {
			try {
				openConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void closeCon() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
	
	public static void main(String[] args) {
		System.out.println(openCon());
	}
}
