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
	try{
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MULCAM";
		String passwd = "MULCAM123";

		Connection conn;
		PreparedStatement pstat;
		
		String teamname = request.getParameter("teamname");			

		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection (url, user, passwd);
		
		String q = "Select * from TEAM_DATA where TEAMNAME=?";
		pstat = conn.prepareStatement(q);

		pstat.setString(1,teamname);
		ResultSet rs = pstat.executeQuery();
		rs.next();			
		
		out.println("<data>");
		out.println("<TEAMNAME>");
		out.println(rs.getString(12));
		out.println("</TEAMNAME>");
		out.println("<LOCAL>");
		out.println(rs.getString(2));
		out.println("</LOCAL>");
		out.println("<RECORD1>");
		out.println(rs.getString(3));
		out.println("</RECORD1>");
		out.println("<RECORD2>");
		out.println(rs.getString(4));
		out.println("</RECORD2>");
		out.println("<MEMBERS>");
		out.println(rs.getString(5));
		out.println("</MEMBERS>");
		out.println("<JARNE>");
		out.println(rs.getString(6));
		out.println("</JARNE>");
		out.println("<INTRO>");
		out.println(rs.getString(7));
		out.println("</INTRO>");
		out.println("<YOUTUBE>");
		out.println(rs.getString(8));
		out.println("</YOUTUBE>");
		out.println("<RECORD3>");
		out.println(rs.getString(9));
		out.println("</RECORD3>");
		out.println("<RECORD4>");
		out.println(rs.getString(10));
		out.println("</RECORD4>");
		out.println("</data>");
		
	} catch ( Exception e ) {			
		e.printStackTrace();
	}
%>

</body>
</html>