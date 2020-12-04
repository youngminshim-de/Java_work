package test.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainClass14 {

	public static void main(String[] args) {
		FileInputStream fin=null;
		FileOutputStream fout=null;
		byte[] buffer;
		
		try {
			fin=new FileInputStream(new File("c:/myFolder/1.jpg"));
			fout=new FileOutputStream(new File("c:/myFolder/copy.jpg"));
			buffer=new byte[1024];
			
			while(true) {
				int readCnt=fin.read(buffer);
				if(readCnt==-1) {break;}
				fout.write(buffer, 0, readCnt);
				fout.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				fin.close();
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
