package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainClass07 {

	public static void main(String[] args) {
		String source="{\"info\":{\"num\":99, \"name\":\"kim\"}, \"nums\":[10,20,30]}";
		JSONObject obj=new JSONObject(source);
		JSONObject info=obj.getJSONObject("info");
		
		int a=info.getInt("num");
		String b=info.getString("name");
		JSONArray nums=obj.getJSONArray("nums");
		
		for(int i=0; i<nums.length(); i++) {
			int tmp=nums.getInt(i);
		}
	}

}
