package test.main;

import test.mypac.MemberDto;

public class MainClass06 {

	public static void main(String[] args) {
		MemberDto memD = new MemberDto(1,"심영민","봉천동");
		// memD.name 이런식으로 직접 참조할떄는 public으로 선언되지 않으면 안된다.
		// public은 다른 package에서도 접근이 가능하다.
		// 매개변수를 이용해서 할때는 public으로 선언하지 않아도 된다.
		// 그 이유는? -> method 가 public으로 선언되어 있어서 그런 것 같다.
	}

}
