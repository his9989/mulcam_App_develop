package com.db;
import java.sql.*;

public class forGrid{

	public static void main(String args[]) {
		// DB가 저장되있는 서버 주소?
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
			//   Java에서 쿼리로 Select를 보내면, 호출 내용이 resultset으로 반환된다.

			// Update : select 외의 나머지. insert, delete, update, create, drop 등 .. 
			//   Java에서 쿼리로 Update를 보내면, 변경 내역의 개수가 int로 반혼된다.

			String q = "Select TEAMNAME, JARNE, LOCAL from TEAM_DATA";
			ResultSet rs = stat.executeQuery(q); 

			// ResultSet 객체의 getXXX()를 이용 SQL문장의 실행결과 얻기				
			// 즉, 결과처리하는 작업
			// rs는 처음에 제목 column을 가리키고 있으므로, rs.next()로 데이터 줄을 하나씩 확인하는 반복 작업이다.
			while(rs.next()) {
				// ResultSet에서는 열은 1부터 시작한다.
				String name = rs.getString(1);
				String jarne = rs.getString(2);
				String local = rs.getString(3);
				
				System.out.println(name+", "+jarne+", "+local+"\n");
			}

			// Statement객체와 Connection객체의 close()호출해서 connection 닫기
			stat.close();
			conn.close();
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
	}
}