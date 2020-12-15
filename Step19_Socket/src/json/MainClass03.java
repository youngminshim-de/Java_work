package json;

import org.json.JSONObject;

public class MainClass03 {

	public static void main(String[] args) {
		String result1="{\"num\":1, \"name\":\"김구라\", \"isMan\":true"
				+ "}";
		System.out.println("result1:"+result1);
		int num=1;
		String name="김구라";
		boolean isMan=true;
		
		String result2="{\"num\":"+Integer.toString(num)+", \"name\":"+"\""+name+"\""+", \"isMan\":"+isMan+"}";
		System.out.println("result2:"+result2);
		
		JSONObject obj=new JSONObject();
		obj.put("num", num);
		obj.put("name", name);
		obj.put("isMan", isMan);
		String result3=obj.toString();
		System.out.println("result3:"+result3);
	}
}
