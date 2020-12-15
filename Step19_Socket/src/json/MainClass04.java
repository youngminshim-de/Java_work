package json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

public class MainClass04 {

	public static void main(String[] args) {
		List<String> names=new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		/*
		 * 	위의 List에 저장된 모든 문자열을 JSON
		 * 	["김구라", "해골", "원숭이"]
		 * 	형식으로 만든다고 가정하자
		 * 	만일 JSON 라이브러리를 사용하지 않는다면 what the fuck
		 */
		String result1="[";
		for(int i=0; i<names.size();i++) {
			result1= (i!=names.size()-1) ? (result1+"\""+names.get(i)+"\""+",") : (result1+"\""+names.get(i)+"\"]");
		}
		System.out.println("result1:"+result1);
		
		JSONArray ary=new JSONArray(names);
		String result2=ary.toString();
		System.out.println("resutl2:"+result2);
		
	}

}
