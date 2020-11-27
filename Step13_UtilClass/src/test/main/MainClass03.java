package test.main;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainClass03 {
	public static void main(String[] args) {
		String name1="김구라";
		String name2="해골";
		String name3="원숭이";
		
		ArrayList<String> str=new ArrayList<>();
		str.add(name1);
		str.add(name2);
		str.add(name3);
		str.add(1, name2);
		str.set(1, name1);
		str.remove(1);
		int size=str.size();
		LinkedList<String> str2=new LinkedList<>();
		str2.add(name1);
		str2.add(name2);
		str2.add(name3);
		str2.remove(1);
		str2.clear();
	}
}
