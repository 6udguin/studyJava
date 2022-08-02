package ex03.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Data Access Object 
public class PostDao {

	Connection         conn  = null;
	
    public PostDao() {
    	conn   =  DBConn.getInstance(); // db 로그인    	
    }
		
	// 한개 주소 조회
	public  PostVo getPost( int seq ) {
		PreparedStatement  pstmt = null;
		ResultSet          rs    = null;
	
		String sql  = "SELECT  ZIPCODE, SIDO, GUGUN, DONG, BUNJI, SEQ ";
		sql        += " FROM   POST ";
		sql        += " WHERE  SEQ = ? ";  
		
		PostVo  vo = null;
		try {
			pstmt  =  conn.prepareStatement( sql );
			pstmt.setInt( 1, seq );
			
			rs     =  pstmt.executeQuery();
			if ( rs.next() ) {
				String zipcode = rs.getString("zipcode");
				String sido    = rs.getString("sido");
				String gugun   = rs.getString("gugun");
				String dong    = rs.getString("dong");
				String bunji   = rs.getString("bunji");
				int    oseq    = rs.getInt("seq");
					
				vo = new PostVo(zipcode, sido, gugun, dong, bunji, oseq);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null )  rs.close();
				if( pstmt != null )  pstmt.close();
			//	if( conn  != null )   conn.close();
			} catch (SQLException e) {
			}
		}
			
		return  vo;
	}

	public ArrayList<PostVo> getDongList(String dong) {
		
		PreparedStatement  pstmt  =  null;
		ResultSet          rs     =  null;
		
		ArrayList<PostVo>  list   =  new ArrayList<>();
		String  sql  = "SELECT  ZIPCODE, SIDO, GUGUN, DONG, BUNJI, SEQ ";
		sql         += " FROM   POST ";
		sql         += " WHERE  DONG LIKE ? ";
	//	sql         += " WHERE  DONG LIKE '%' || ? || '%' ";
		
		try {
			pstmt  =  conn.prepareStatement( sql );
			pstmt.setString(1, "%" + dong + "%");
			// pstmt.setString(1,  dong );
			rs     =  pstmt.executeQuery();
			while( rs.next() ) {
				String  zipcode  =  rs.getString("zipcode");
				String  sido     =  rs.getString("sido");
				String  gugun    =  rs.getString("gugun");
				String  odong    =  rs.getString("dong");
				String  bunji    =  rs.getString("bunji");
				int     seq      =  rs.getInt("seq");
				
				PostVo  vo       =  new PostVo(zipcode, sido, gugun, odong, bunji, seq);
				
				list.add( vo );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if( rs    != null ) rs.close();
				if( pstmt != null ) pstmt.close();
			} catch (SQLException e) {
			}
		}						
		
		return  list;
	}

	public void close() {
		
		try {
			if(conn != null)  conn.close();
		} catch (SQLException e) {
		}
	}  
}





