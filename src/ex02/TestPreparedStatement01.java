package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreparedStatement01 {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "hr";
	private static String dbpwd  = "1234";	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection        conn   =  DriverManager.getConnection(url, dbuid, dbpwd);
		String            sql    = ""; 
		sql     += " SELECT   D.DEPARTMENT_NAME  DNAME,";
		sql     += "          DECODE ( E.FIRST_NAME || ' ' || E.LAST_NAME,  ' ',";
		sql     += "                 '직원없음',  ";
		sql     += "                 E.FIRST_NAME || ' ' || E.LAST_NAME )  ENAME ";
		sql     += "  FROM    DEPARTMENTS  D left join  EMPLOYEES E";
		sql     += "   on  D.DEPARTMENT_ID = E.DEPARTMENT_ID";
		System.out.println( sql );
		PreparedStatement pstmt  =  conn.prepareStatement( sql );
		pstmt.setString(1, "");
		ResultSet         rs     =  pstmt.executeQuery();
		while( rs.next() ) {
			System.out.print ( rs.getString("dname") + "," );
			System.out.println( rs.getString("ename") );
		}
		rs.close();
		pstmt.close();
		conn.close();
				
	}

}








