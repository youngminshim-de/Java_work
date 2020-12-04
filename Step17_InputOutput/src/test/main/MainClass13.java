package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainClass13 {

	public static void main(String[] args){
		
		int data=0;
		int readCnt=0;
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			
			fis=new FileInputStream(new File("c:/myFolder/1.jpg"));
			fos=new FileOutputStream(new File("c:/myFolder/copy.jpg"));
			
			byte[] cbuf=new byte[1024];
			long start =System.currentTimeMillis();
			while(true) {
				// 첫 번째 byte 단위 복사
				data=fis.read();
				if(data==-1) {
					break;
				}
				fos.write(data);
				
			    // 두번째 buffer 단위 작업 (속도향상)
				// 읽은 데이터에 수를 센다 .일반적으로는 cbuf사이즈만큼이겠지만
				// 마지막의 경우 size가 다르니 그 사이즈를 알아놓고 write할때 써야한다.
				// 그렇지 않으면 쓰레기값이 들어가 파일이 깨질 수 있다.
				readCnt=fis.read(cbuf);
				if(readCnt==-1) {break;}
				fos.write(cbuf, 0, readCnt);
				
				fos.flush();
			}
			long end=System.currentTimeMillis();
			System.out.println("복사하는데 걸린 시간은 :" +(end-start)+"mill");

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
