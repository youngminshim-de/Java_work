package test.mypac;

public class SmartPhone extends HandPhone{
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	// @:어노테이션(Annotation) : 이메소드는 재정의한 메소드라고 표시
	// 특별한 기능은 x, 단지 재정의(Override)한 메소드라고 표시해준다.
	@Override
	public void takePicture() {
		super.takePicture();
		System.out.println("스마트폰으로 사진을 찍어요");
	}

}
