package com.db;
import java.sql.*;

public class forGrid{

	public static void main(String args[]) {
		// DB�� ������ִ� ���� �ּ�?
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MULCAM";
		String passwd = "MULCAM123";

		Connection conn;
		Statement stat;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection (url, user, passwd);
			stat = conn.createStatement();
			
			// Query : select
			//   Java���� ������ Select�� ������, ȣ�� ������ resultset���� ��ȯ�ȴ�.

			// Update : select ���� ������. insert, delete, update, create, drop �� .. 
			//   Java���� ������ Update�� ������, ���� ������ ������ int�� ��ȥ�ȴ�.

			String q = "Select TEAMNAME, JARNE, LOCAL from TEAM_DATA";
			ResultSet rs = stat.executeQuery(q); 

			// ResultSet ��ü�� getXXX()�� �̿� SQL������ ������ ���				
			// ��, ���ó���ϴ� �۾�
			// rs�� ó���� ���� column�� ����Ű�� �����Ƿ�, rs.next()�� ������ ���� �ϳ��� Ȯ���ϴ� �ݺ� �۾��̴�.
			while(rs.next()) {
				// ResultSet������ ���� 1���� �����Ѵ�.
				String name = rs.getString(1);
				String jarne = rs.getString(2);
				String local = rs.getString(3);
				
				System.out.println(name+", "+jarne+", "+local+"\n");
			}

			// Statement��ü�� Connection��ü�� close()ȣ���ؼ� connection �ݱ�
			stat.close();
			conn.close();
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
	}
}