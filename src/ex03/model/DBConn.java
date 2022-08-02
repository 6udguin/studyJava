package ex03.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

	// mvc + singlton pattern
	private static  String      driver = "oracle.jdbc.OracleDriver";
	private static  String      url    = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static  String      dbuid  = "test";
	private static  String      dbpwd  = "1234";
	
	private static  Connection  conn   = null;
	
	// 생성자
	private  DBConn() {		
	}
	
	public  static Connection   getInstance() {
		if( conn  != null) 
			return conn;
		
		try {
			Class.forName(driver);  // ojdbc11.jar 를 불러오겠다
			conn   =  DriverManager.getConnection(url, dbuid, dbpwd); // 오라클 록그인
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;		
	} 	
		
}




