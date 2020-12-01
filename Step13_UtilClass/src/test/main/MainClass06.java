package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.MemberDto;

public class MainClass06 {

	public static void main(String[] args) {
		List<MemberDto> members=new ArrayList<>();
		members.add(new MemberDto(1,"심영민","봉천동"));
		members.add(new MemberDto(2,"김구라","아현동"));
		members.add(new MemberDto(3,"해골","노량진"));
		
		for(int i=0; i<members.size(); i++) {
			System.out.print("번호는 " + members.get(i).getNum());
			System.out.print(" 이름은 " + members.get(i).getName());
			System.out.println(" 주소는 " + members.get(i).getAddr());
		}
		for(MemberDto tmp:members) {
			System.out.print("번호는 " + tmp.getNum());
			System.out.print(" 이름은 " + tmp.getName());
			System.out.println(" 주소는 " + tmp.getAddr());
		}
	}

}
