package test.main;

public class MainClass01 {
/*
 *  [기본 데이터 type 에 대응되는 참조 data type]
 * 	byte : Byte
 * 	short : Short
 * 	int : Integer
 * 	long : Long
 * 
 *  float : Float
 *  double : Double
 *  
 *  char : Character
 *  boolean : Boolean
 */
	public static void main(String[] args) {
		// 기본 데이터 type
		int num1=10;
		// 참조 데이터 type
		Integer num2=10;
		
		//참조 데이터 type 이지만 기본 데이터 type과 동일하게 사용할 수 있다.
		int result1=num2+1;
		int result2=num1+num2;
		Integer result3=num1+num2;
		
		/*
		 * Integer Type 의 메소드를 이용해서
		 * 
		 *  10 => "10"으로 바꾸기
		 */
		String result4=num2.toString();
		
		/*
		 * Integer class의 static 메소드를 이용해서
		 * "999" -> 999 정수로 바꾸기
		 */
		int reulst5=Integer.parseInt(result4);
	}

}
