package test.mypac;

public class MyUtil {
	
	public static String owner = "심영민";
	public String owner2 = "심영민";
	// static이 붙으면 객체 없이 class 이름에 바로 사용가능 ex) MyUtil.playMusic();
	// static method 에서는 static 변수만 참조가능
	public static void playMusic() {
		System.out.println("음악을 틀어요!");
		
		// 생성자를 만들어서 참조는 된다.
		// static method에서 참조하는게 아니라 Myutil의 instance에서 참조하는 거니 되겠지
		String o = new MyUtil().owner2;
	}

}
