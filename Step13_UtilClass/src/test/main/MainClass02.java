package test.main;

import java.util.HashMap;
import java.util.Map;


public class MainClass02 {
	public static void main(String[] args) {
		int num=1;
		String name="김구라";
		String addr="노량진";
		boolean isMan=true;
		// 보통 K(key)=String & V(Value)=Object type으로 많이한다.
		Map<String, Object> hmap=new HashMap<>();
		hmap.put("num", num);
		hmap.put("name",name);
		hmap.put("addr",addr);
		hmap.put("isMan", isMan);
		
		int a=(int)hmap.get("num");
		String b=(String)hmap.get("name");
		String c=(String)hmap.get("addr");
		Boolean d=(Boolean)hmap.get("isMan");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(hmap.size());
	}

}
