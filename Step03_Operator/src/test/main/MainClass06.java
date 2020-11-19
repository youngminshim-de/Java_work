package test.main;
/*
 *  6. 3항 연산자 테스트
 *  boolean type ? "true일때" : "false일때"
 */
public class MainClass06 {

	public static void main(String[] args) {
		boolean isWait = false
				;
		
		String result = isWait ? "기다려요" : "기다리지 않아요";
		 /*if(isWait){result = "기다려요");}
		 * else{result = "기다리지 않아요";} 와 동일
		 */
		
		System.out.println(result);
		
		String result2 =null;
		
		if(isWait) {result2="기다려요";}
		else {result2="기다리지 않아요";}
		System.out.println(result2);

	}

}
