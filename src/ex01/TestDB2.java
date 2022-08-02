package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB2 {
	
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "hr";
	private static String dbpwd  = "1234";	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 이름입력 받아서 kim을 포함하는 사람을 검색하라
		Scanner     sc    =  new Scanner(System.in);
		
		Class.forName(driver);
		Connection  conn  =  DriverManager.getConnection(url, dbuid, dbpwd);
		Statement   stmt  =  conn.createStatement();
		
		// 이름입력
		System.out.println("이름:");
		String    name  =  sc.nextLine().trim().toLowerCase();
			
		String      sql   =  "";
		//                 1            2                              3
		sql  += "SELECT  EMPLOYEE_ID, FIRST_NAME || ' ' || LAST_NAME , EMAIL  ";
		sql  += " FROM   EMPLOYEES ";         
		sql  += " WHERE  LOWER(FIRST_NAME) LIKE '%" + name + "%'";         
		sql  += " OR     LOWER(LAST_NAME)  LIKE '%" + name + "%'";         
		
		ResultSet   rs    =  stmt.executeQuery( sql );
		while( rs.next() ) {
			int     eno     =  rs.getInt("EMPLOYEE_ID");
			String  ename   =  rs.getString(2);  // 1~
			// String  ename   =  rs.getString("FIRST_NAME || ' ' || LAST_NAME");  // error
			String  email   =  rs.getString("EMAIL");
			String  fmt     =  " %d, %s, %s ";
			String  msg     =  String.format(fmt, eno, ename, email); 
			System.out.println( msg );			
		}
		rs.close();
		stmt.close();
		conn.close();

	}

}





