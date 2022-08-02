package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPreparedStatement02 {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "test";
	private static String dbpwd  = "1234";	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 테이블 생성
		Class.forName(driver);
		Connection         conn   = DriverManager.getConnection(url, dbuid, dbpwd);
		String             sql1   = "DROP TABLE TUSER2";
		PreparedStatement  pstmt1 = conn.prepareStatement(sql1);
		pstmt1.executeUpdate();
		
		String             sql2   = "CREATE  TABLE  TUSER2 (";
 		sql2                     += "  USERID    VARCHAR2(12)  PRIMARY KEY"; 
		sql2                     += ", PASSWD    VARCHAR2(12)  NOT NULL"; 
		sql2                     += ", USERNAME  VARCHAR2(30) "; 
		sql2                     += ", INDATE    DATE          DEFAULT SYSDATE"; 
		sql2                     += ")"; 
		PreparedStatement  pstmt2 = conn.prepareStatement(sql2);
		
		pstmt2.executeUpdate();  
				
		pstmt1.close();
		pstmt2.close();
		conn.close();
	}

}







