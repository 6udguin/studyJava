package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDB01 {
	private static  String driver  =  "oracle.jdbc.OracleDriver";
	private static  String dburl   =  "jdbc:oracle:thin:@localhost:1521:xe";
	private static  String dbuid   =  "hr";
	private static  String dbpwd   =  "1234";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 이름입력 받아서 kim을 포함하는 사람을 검색하라
		Class.forName(driver);
		Connection   conn  =  DriverManager.getConnection(dburl, dbuid, dbpwd);
		Statement    stmt  =  conn.createStatement();
		String       sql   =  "SELECT EMPLOYEE_ID,";
		sql               +=  " FIRST_NAME || ' ' || LAST_NAME ENAME ";
		sql               +=  " FROM EMPLOYEES";
		System.out.println(sql );
		ResultSet    rs    =  stmt.executeQuery( sql ); 
	    while( rs.next() ) {
		    System.out.print( rs.getInt("EMPLOYEE_ID") + ", ");
		    System.out.println( rs.getString("ENAME") );
	    }
	    rs.close();
		stmt.close();
		conn.close();
		
		
	}

}








