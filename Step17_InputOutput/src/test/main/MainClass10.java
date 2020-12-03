package test.main;

import java.io.File;

public class MainClass10 {

	public static void main(String[] args) {
		
		for(int i=0; i<10; i++) {
			File temp=new File("c:/myFolder/gura"+i);
			if(!temp.exists()) {
				temp.mkdir();
				System.out.println("c:/myFolder 하위에 폴더생성");
			}
			else {
				temp.delete();
				System.out.println("c:/myFolder 하위에 있는 내용 삭제");
			}
		}

	}

}
