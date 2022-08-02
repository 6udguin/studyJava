package ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestPreparedStatement03 {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url    = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid  = "test";
	private static String dbpwd  = "1234";	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// INSERT, DELETE, UPDATE
		// PreparedStatement  의 ? : parameter  
		// 첫번째 실행하면 1건 입력되었습니다
		// 두번째 실행하면 ORA-00001: 무결성 제약 조건(TEST.SYS_C008573)에 위배됩니다 
		//   -> primary key 위반 중복입력됨
		Class.forName(driver);
		Connection          conn    =  DriverManager.getConnection(url, dbuid, dbpwd);
		String              sql     =  "";
		sql  +=  " INSERT  INTO  TUSER ( USERID, PASSWD, USERNAME ) ";
		sql  +=  " VALUES  ( ?, ?, ? ) "; 	
		// VALUES       ( 'SEA3', '1234', '바다3' );   
		PreparedStatement   pstmt   =  conn.prepareStatement( sql );
		pstmt.setString(1, "SEA3" );   // '' 는 SETsTRING 을 사용하면 무조건 추가되므로 ' 입력 x
		pstmt.setString(2, "1234" ); 
		pstmt.setString(3, "바다3" ); 
		
		int aftcnt = pstmt.executeUpdate( );
		System.out.println( aftcnt + "건 추가되었습니다");
		
		pstmt.close();
		conn.close();

	}

}





