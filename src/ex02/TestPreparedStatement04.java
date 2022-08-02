package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedStatement04 {

	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "test";
	private static String dbpwd  = "1234";	
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner  sc  = new Scanner( System.in );
		
		String userid, passwd, username;
		System.out.println("아이디:");
		userid = sc.nextLine();
		System.out.println("암호:");
		passwd = sc.nextLine();
		System.out.println("이름:");
		username = sc.nextLine();

		System.out.println( "\n--추가전--" );
		tuser_getUserList();
		
		tuser_addUser( userid, passwd, username);

		System.out.println( "\n--추가후--" );
		tuser_getUserList();

	}

	private static void tuser_addUser(String userid, String passwd, String username) 
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection         conn   =  DriverManager.getConnection(url, dbuid, dbpwd);
		String             sql    =  "INSERT INTO TUSER ( USERID, PASSWD, USERNAME )";
		sql                      +=  " VALUES ( ?, ?, ? ) ";		
		PreparedStatement  pstmt  =  conn.prepareStatement( sql );
		pstmt.setString(1, userid);      // 첫번째 ?   setString() 자동으로  ' ' 를 둘러싸준다 
		pstmt.setString(2, passwd);      // 두번째 ? 
		pstmt.setString(3, username);    // 세번째 ? 
		
		int aftcnt  =  pstmt.executeUpdate();  // 추가된 자료수
		System.out.println(userid + " " + aftcnt + "건 추가됨");
		
		pstmt.close();
		conn.close();
		
	}

	private static void tuser_getUserList() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection        conn   =  DriverManager.getConnection(url, dbuid, dbpwd);
		String            sql    =  "SELECT  USERID, PASSWD, USERNAME, INDATE FROM TUSER"; 
		PreparedStatement pstmt  =  conn.prepareStatement(sql);
		ResultSet         rs     =  pstmt.executeQuery( );
		System.out.println("아이디, 암호, 이름, 가입일");
		while( rs.next() ) {
			String  userid    =  rs.getString("userid"); 
			String  passwd    =  rs.getString("passwd"); 
			String  username  =  rs.getString("username"); 
			String  indate    =  rs.getString("indate");
			String  fmt       =  "%s, %s, %s, %s";  
			String  msg       =  String.format(fmt, userid, passwd, username, indate); 
			System.out.println( msg );
		}		
		rs.close();
		pstmt.close();
		conn.close();
		
	}

}








