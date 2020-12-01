package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *  HashSet 클래스는 Set 인터페이스를 구현한 클래스이다.
 *  - 데이터를 순서없이 저장한다.
 *  - key 값도 없다.
 *  - 중복을 허용하지 않는다.
 *  - 어떤 data 를 집합의 형태로 관리하고자 할 때 사용한다.
 *  - 중복을 제거 할때도 유용하다.
 */

public class MainClass09 {
	public static void main(String[] args) {
		
		Set<Integer> set1=new HashSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.add(2);
		set1.add(3);
		set1.toArray();
		
		Iterator<Integer> it=set1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
