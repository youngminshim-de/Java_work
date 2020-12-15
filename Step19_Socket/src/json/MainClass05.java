package json;

import org.json.JSONArray;

public class MainClass05 {

	public static void main(String[] args) {
		/*
		 * 	인터넷으로 부터 다운받은 문자열이 JSON 형식인 경우도 많이 발생한다.
		 * 	해당 문자열에서 원하는 정보를 추출하는 연습을 해 보자
		 */
		String info="[10,20,30,40,50]";
		JSONArray ary=new JSONArray(info);
		for(int i=0; i<ary.length(); i++) {
			System.out.println(i+" 번째 인덱스 : "+ary.getInt(i));
		}
		String info2="[심영민,심수정,심봉오,김향순]";
		JSONArray ary2=new JSONArray(info2);
		for(int i=0; i<ary2.length(); i++) {
			System.out.println(i+" 번째 인덱스 : "+ary2.getString(i));
		}
		String info3="[10,심영민,심수정,20,30,40]";
		JSONArray ary3=new JSONArray(info3);
		for(int i=0; i<ary3.length(); i++) {
			System.out.println(ary3.get(i));
			
		}
		
		
	}
	

}
