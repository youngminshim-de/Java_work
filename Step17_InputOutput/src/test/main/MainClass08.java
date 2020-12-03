package test.main;

import java.io.File;

public class MainClass08 {
	public static void main(String[] args) {
		File myFile=new File("c:/");
		File[] fileAry=myFile.listFiles();
		for(File tmp:fileAry) {
			if(tmp.isDirectory()) {
				System.out.println("["+tmp.getName()+"]");
			}
			else {
				System.out.println(tmp.getName());
			}
		}
	}
}
