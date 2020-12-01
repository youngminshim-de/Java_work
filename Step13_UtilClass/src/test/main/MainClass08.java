package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  1. 3명의 회원 정보를 HashMap 객체를 3개 생성해서 각각 담아보세요
		 *  	번호 -> "num" 이라는 키값으로 정수 저장
		 *  	이름 -> "name" 이라는 키값으로 문자열 저장
		 *  	주소 -> "addr" 이라는 키값으로 문자열 저장
		 */
		
		Map<String, Object> info1=new HashMap<>();
		info1.put("num", 1);
		info1.put("name", "심영민");
		info1.put("addr","봉천동");

		Map<String, Object> info2=new HashMap<>();
		info2.put("num",(int)2);
		info2.put("name", "김구라");
		info2.put("addr", "노량진");
		
		Map<String, Object> info3=new HashMap<>();
		info3.put("num",(int)3);
		info3.put("name","해골");
		info3.put("addr","신림동");
		
		List<Map<String,Object>> members=new ArrayList<>();

		members.add(info1);
		members.add(info2);
		members.add(info3);
		
		for(Map<String, Object> h:members) {
			int num=(int)h.get("num");
			String name=(String)h.get("name");
			String addr=(String)h.get("addr");
			
			System.out.print("번호 : "+num+", ");
			System.out.print("이름 : "+name+", ");
			System.out.println("주소 : "+addr);
		}
			
	}

}
