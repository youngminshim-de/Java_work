package test.main;

import test.mypac.Remocon;

public class MainClass04 {

	public static void main(String[] args) {
		// 인스턴스 생성해서 r1에 담아 사용
		Remocon r1=new Remocon() {

			@Override
			public void up() {
				System.out.println("볼륨을 올려요");
			}

			@Override
			public void down() {
				System.out.println("볼륨을 내려요");
			}
			
		};
		// 일회성으로 직접 생성해서 함수에 전달
		useRemocon(new Remocon() {

			@Override
			public void up() {
				System.out.println("일회성으로 직접 올려요");
				
			}

			@Override
			public void down() {
				System.out.println("일회성으로 직접 내려요");
				
			}
			
		});

	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}

}
