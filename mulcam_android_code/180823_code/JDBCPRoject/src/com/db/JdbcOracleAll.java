package com.db;
import java.sql.*;

public class JdbcOracleAll{

	public static void main(String args[]) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "";
		String passwd = "";

		Connection conn;
		Statement stat;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection (url, user, passwd);
		
			stat = conn.createStatement();
			
			ResultSet rs = stat.executeQuery(""); 

			while(rs.next()) {
				
			}

			stat.close();
			conn.close();
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
	}
}