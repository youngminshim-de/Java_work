package test.main;

import test.member.dao.TodoDao;
import test.member.dto.TodoDto;

public class MainClass12 {

	public static void main(String[] args) {
		TodoDto dto;
		TodoDao dao=new TodoDao();
		dto=dao.select(2);
		System.out.println(dto.getNum());
		System.out.println(dto.getContent());
		System.out.println(dto.getRegdate());

	}

}
