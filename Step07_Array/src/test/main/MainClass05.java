package test.main;
import test.mypac.Rect;
public class MainClass05 {

	public static void main(String[] args) {
		/*
		 *  1. 가로 세로 100,100 // 200,100 // 300,200
		 *  	인 사각형 3개를 만들어봐라.
		 *  
		 *  2. rect1, rect2, rect3에 담긴 참조값을 배열에 순서대로 담아보시오.
		 * 		배열의 참조값이 담길 지역 변수의 이름은 rects로 선언하세요.
		 * 
		 *  3. rects 배열에 담긴값을 참조하여 getArea() 메소드를 호출
		 *  	return 값을 이용하여 사각형의 넓이를 출력하시오.
		 */
		
		Rect rect1=new Rect(100,100);
		Rect rect2=new Rect(200,100);
		Rect rect3=new Rect(300,200);
		
		Rect[] rects=new Rect[3];
		rects[0] = rect1;
		rects[1] = rect2;
		rects[2] = rect3;
		
		for(Rect r : rects) {
			System.out.println("사각형의 넓이: "+r.getArea());
		}
	}
}
