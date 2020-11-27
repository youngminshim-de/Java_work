package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	// Inner Class (static method내에서 사용하니 static 붙였다)
	static class AirconRemocon implements Remocon{

		@Override
		public void up() {
			System.out.println("온도를 올려요");
			
		}

		@Override
		public void down() {
			System.out.println("온도를 내려요");
			
		}
	}
	public static void main(String[] args) {
		// Remocon interface를 구현한 Local Inner Class
		class TvRemocon implements Remocon{

			@Override
			public void up() {
				System.out.println("TV볼륨을 높여요");
				
			}

			@Override
			public void down() {
				System.out.println("TV볼륨을 내려요");
				
			}
		}
		Remocon r1=new TvRemocon();
		useRemocon(r1);
		Remocon r2=new AirconRemocon();
		useRemocon(r2);
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
