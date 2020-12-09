package test.main;
/*
 * 	아래는 member 테이블에 저장된 회원의 번호라고 가정하자
 * 	하지만 저 번호의 회원이 존재하는지 여부는 알지 못한다.
 * 	만일 존재한다면 해당회원의 정보를 콘솔창에 출력하고
 * 	존재하지 않는다면 존재하지 않는다고 콘솔창에 출력해보라.
 * 
 */

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass11 {

	public static void main(String[] args) {
		int num1=15;
		int num2=20;
		
		MemberDto member;
		MemberDao dao=new MemberDao();
		member=dao.selectMember(num1);
		if(member!=null) {
			System.out.println(member.getNum()+"번 회원 "
							+"이름 :"+member.getName()+"주소 : "+member.getAddr());
		}else {
			System.out.println(num1+"번 회원은 존재하지 않습니다.");
		}
		member=dao.selectMember(num2);
		if(member!=null) {
			System.out.println(member.getNum()+"번 회원 "
							+"이름 :"+member.getName()+"주소 : "+member.getAddr());
		}else {
			System.out.println(num2+"번 회원은 존재하지 않습니다.");
		}
		
	}

}
