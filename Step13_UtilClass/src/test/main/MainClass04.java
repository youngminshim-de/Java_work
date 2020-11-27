package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass04 {
	public static void main(String[] args) {
		// 정수를 저장할 ArrayList 객체를 생성해서
		// 참조값을 nums라는 지역변수에 담아보셈
		List<Integer> nums=new ArrayList<>();
		// 원래는 아래 모양이지만 Auto-boxing 된다.
		// nums.add(new Integer(10));
		nums.add(10);
		nums.add(20);
		nums.add(30);
		
		List<Float> nums2=new ArrayList<>();
		nums2.add(10.0f);
		nums2.add(20.0f);
		nums2.add(30.0f);
		
		// Generic <> 자리에 참조변수가 아닌 class명을 직접 넣어야한다.
		ArrayList<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> hmap1=new HashMap<>();
		hmap1.put("num","1");
		hmap1.put("name","심영민");
		hmap1.put("addr","봉천동");
		
		list.add(hmap1);
		
	}
}
