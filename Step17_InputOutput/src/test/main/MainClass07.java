package test.main;

import java.io.File;

public class MainClass07 {

	public static void main(String[] args) {
		File myFile=new File("c:/");
		String[] fileNames=myFile.list();
		for(String str:fileNames) {
			System.out.println(str);
		}
	}

}
