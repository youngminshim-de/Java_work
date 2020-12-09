package test.main;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass09 {

	public static void main(String[] args) {
		MemberDao dao=new MemberDao();
		boolean isSuccess;
//		isSuccess=dao.deleteMember(3);
//		if(isSuccess) {
//			System.out.println("삭제 성공!");
//		}else {
//			System.out.println("삭제 실패!");
//		}
		
		MemberDto member=new MemberDto();
		member.setName("유재성");
		member.setAddr("압구정");
		isSuccess=dao.insertMember(member);
		
		if(isSuccess) {
			System.out.println("추가 성공!");
		}else {
			System.out.println("추가 실패!");
		}
		
		MemberDto member1=dao.selectMember(4);
		
		MemberDto member2=new MemberDto();
		member2.setNum(4);
		member2.setAddr("노량진");
		member2.setName("노량진");
		
		isSuccess=dao.updateMember(member2);
		if(isSuccess) {
			System.out.println("수정 성공!");
		}else {
			System.out.println("수정 실패!");
		}
	}

}
