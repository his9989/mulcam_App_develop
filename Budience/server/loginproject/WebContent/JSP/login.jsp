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
//jsp���Ͽ��� java code ���� ��

try {
			String id = request.getParameter("id");			
			String pw = request.getParameter("pass");
			String check=null;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "MULCAM";
		String passwd = "MULCAM123";
		String s = "select pw from LOGIN_DATA where id=?";
		Connection conn;
		PreparedStatement pstat;
		boolean logincheck=false;
		
			//1.jdbc driver ���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.connection ��ü ����(network ����)
			conn = DriverManager.getConnection (url, user, passwd);
			
			//3.Statement��ü ����(query �ϳ��� ������ �ִ� �׸�)
			pstat = conn.prepareStatement(s);		
			pstat.setString(1,id);
			ResultSet rs = pstat.executeQuery();
			rs.next();			
			
			check = rs.getString(1);
			System.out.println(check);
			if(check.equals(pw)){
				logincheck=true;
			}
			
			if(logincheck)
				out.println("<data><result>true</result></data>");
			else
				out.println("<data><result>false</result></data>");
			pstat.close();
			conn.close(); 
		} catch ( Exception e ) {			
			e.printStackTrace();
		}
%>
</body>
</html>