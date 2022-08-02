package ex04;

public class TestTryCatch {

	public static void main(String[] args) {
		
		int  a = 7, b = 0;
		
		try {
			int  c = a / b;
			System.out.println( c );
		} catch (Exception e) {
			//System.out.println( e.getMessage() );
			e.printStackTrace();
		} finally {
			int  d = a + b;
			System.out.println( d );			
		}
		
		
		
	}

}
