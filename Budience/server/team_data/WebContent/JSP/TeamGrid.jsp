<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
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
	
		String q = "Select NAME, JARNE, LOCAL, TEAMNAME from TEAM_DATA";
		ResultSet rs = stat.executeQuery(q); 
	
		// ResultSet ��ü�� getXXX()�� �̿� SQL������ ������ ���				
		// ��, ���ó���ϴ� �۾�
		// rs�� ó���� ���� column�� ����Ű�� �����Ƿ�, rs.next()�� ������ ���� �ϳ��� Ȯ���ϴ� �ݺ� �۾��̴�.
		while(rs.next()) {
			// ResultSet������ ���� 1���� �����Ѵ�.
			//String name = rs.getString(1);
			//String jarne = rs.getString(2);
			//String local = rs.getString(3);
			
			// System.out.println(rs.getString(1)+", "+rs.getString(2)+", "+rs.getString(3)+"\n");
			out.println("<team>");
			out.println("<name>");
			out.println(rs.getString(1));
			out.println("</name>");
			out.println("<jarne>");
			out.println(rs.getString(2));
			out.println("</jarne>");
			out.println("<local>");
			out.println(rs.getString(3));
			out.println("</local>");
			out.println("<Teamname>");
			out.println(rs.getString(4));
			out.println("</Teamname>");
			out.println("</team>");
		}
		// Statement��ü�� Connection��ü�� close()ȣ���ؼ� connection �ݱ�
		stat.close();
		conn.close();
	} catch ( Exception e ) {			
		e.printStackTrace();
	}
%>
</body>
</html>