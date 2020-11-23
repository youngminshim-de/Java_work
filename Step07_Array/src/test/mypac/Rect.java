package test.mypac;

public class Rect {
	
	private int width;
	private int height;
	private int area;
	// 생성자의 매개변수로 width, height를 전달받아 초기화하는
	// 생성자를 정의하시오
	
	//사각형의 넓이를 리턴하는 메소드를 정의하시오(메소드 이름 :getArea())
	public Rect(int w, int h) {
		this.width=w;
		this.height=h;
	}
	
	public int getArea() {
		area=width*height;
		return area;
	}
}
