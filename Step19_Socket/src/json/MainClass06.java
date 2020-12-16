package json;
/*
 * 	[ Java 객체와 JSON 문자열의 관계]
 * 
 * 	Map => JSONObject => { }
 * 
 * 	List => JSONArray => [ ]
 * 
 * 	[ JSON 문자열과 Java 객체, 데이터와의 관계 ]
 * 
 * 	{ } => JSONObject
 * 	[ ] => JSONArray
 * 	10 => int
 * 	10.1 => double
 * 	"xxx" => String
 * 	true => boolean
 *
 */

import org.json.JSONObject;

public class MainClass06 {
	
	public static void main(String[] args) {
		String info="{\"num\":1, \"name\":\"심영민\", \"isMan\":true}";
		System.out.println(info);
		JSONObject obj=new JSONObject(info);
		int a=obj.getInt("num");
		String b=obj.getString("name");
		boolean c=obj.getBoolean("isMan");

	}
}
