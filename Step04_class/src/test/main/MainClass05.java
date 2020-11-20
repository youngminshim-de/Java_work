package test.main;

import test.mypac.Member;
import test.mypac.MemberDto;

public class MainClass05 {

	public static void main(String[] args) {
		Member mem1 = new Member();
		Member mem2 = new Member();
		mem1.num = 1;
		mem1.name ="심영민";
		mem1.addr="봉천동";
		mem2.num = 2;
		mem2.name ="김구라";
		mem2.addr="봉천동";
		
		mem1.showInfo();
		mem2.showInfo();
		
		
		
	}

}
