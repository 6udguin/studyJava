package ex03.view;

import java.util.ArrayList;
import java.util.Scanner;

import ex03.model.DBConn;
import ex03.model.PostDao;
import ex03.model.PostVo;

public class TestPost {

	public static void main(String[] args) {
				
		Scanner   sc   = new Scanner(System.in);
		System.out.println("번호입력(주소번호):");
		int       seq  = sc.nextInt();   // 
		sc.nextLine();   // 엔터즐 제거한다
		
		PostDao   dao  =  new PostDao();
		
		PostVo    vo   =  dao.getPost( seq );
		if( vo == null )
			System.out.println("조회한 자료가 없습니다");
		else
			System.out.println( vo.toString() );
		System.out.println("==================");
		
		
		System.out.println("동명입력:"); 
		String              dong     =  sc.nextLine();   
		ArrayList<PostVo>   dongList =  dao.getDongList( dong );
		if( dongList.size() == 0 ) {
			System.out.println("조회한 자료가 없습니다");
		} else {
			for (int i = 0; i < dongList.size(); i++) {
				PostVo post = dongList.get(i);
				System.out.println( post  );
			}
		}

		dao.close();
		
	}

}





