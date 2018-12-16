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
			//1.jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.connection 객체 얻어내기(network 연결)
			conn = DriverManager.getConnection (url, user, passwd);
			stat = conn.createStatement();
			//3.Statement객체 얻어내기(query 하나를 담을수 있는 그릇)
			String s = "select * from PERFOR_DATA";
			ResultSet rs = stat.executeQuery(s);
			
			out.println("<root>");
			while(rs.next()){
				out.println("<data>");
				out.println("<TEAMNAME>");
				out.println(rs.getString(1));
				out.println("</TEAMNAME>");
				out.println("<GENRE>");
				out.println(rs.getString(2));
				out.println("</GENRE>");
				out.println("<INTRO>");
				out.println(rs.getString(3));
				out.println("</INTRO>");
				out.println("<STARTTIME>");
				out.println(rs.getTime(4));
				out.println("</STARTTIME>");
				out.println("<LOCX>");
				out.println(rs.getString(5));
				out.println("</LOCX>");
				out.println("<LOCY>");
				out.println(rs.getString(6));
				out.println("</LOCY>");
				out.println("<ENDTIME>");
				out.println(rs.getTime(7));
				out.println("</ENDTIME>");
				out.println("</data>");
			}
			out.println("</root>");
			
			stat.close();
			conn.close(); 
			
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
%>
</body>
</html>