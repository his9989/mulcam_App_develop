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
//jsp파일에서 java code 적는 곳

try {
			String id = request.getParameter("id");			
			String pw = request.getParameter("pw");
			
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MULCAM";
		String passwd = "MULCAM123";
		String s = "insert into LOGIN_DATA values(?,?)";
		Connection conn;
		PreparedStatement pstat;
		
			//1.jdbc driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.connection 객체 얻어내기(network 연결)
			conn = DriverManager.getConnection (url, user, passwd);
			
			//3.Statement객체 얻어내기(query 하나를 담을수 있는 그릇)
	pstat = conn.prepareStatement(s);		
			pstat.setString(1,id);
			pstat.setString(2,pw);
			pstat.executeUpdate();
			out.println("<data><result>true</result></data>");
			
			pstat.close();
			conn.close(); 
			
			out.println("<data><result>true</result></data>");
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
%>
</body>
</html>