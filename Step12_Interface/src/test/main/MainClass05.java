package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("구멍을 뚫어요");
			}
		});
		// 같은표현(interface내에 메소드가 하나일경우)
		useDrill(()->{
			System.out.println("구멍뚫기");
		});
		
		Drill d1=()->{
			System.out.println("이것도 같은표현");
		};
		useDrill(d1);
		
	}

	public static void useDrill(Drill d) {
		d.hole();
	}
}
