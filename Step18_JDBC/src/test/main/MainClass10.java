package test.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

/*
 * 	추가할 회원의 정보가 아래와 같을때 아래 회원의 정보를
 * 	member 테이블에 추가하려면 ?
 */


public class MainClass10 {

	public static void main(String[] args) {
		String name="섯거라";
		String addr="신길동";
		boolean isSuccess;
		
		MemberDto member=new MemberDto();
		member.setName(name);
		member.setAddr(addr);
		
		MemberDao dao=new MemberDao();
		isSuccess=dao.insertMember(member);
		if(isSuccess) {
			System.out.println("회원정보 추가 성공");
		}else {
			System.out.println("회원정보 추가 실패");
		}
		
	}	
}
