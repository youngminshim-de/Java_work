package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import test.util.DBConnect;

/*
 * 	검색할 회원의 번호를 입력받아서
 *  DB에서 찾아내고
 *  결과 값이 있으면 회원정보 콘솔창에 출력
 *  결과 값이 없으면 해당 회원은 존재 하지 않습니다. 라고 출력되는 프로그램을 만들어 보세요
 *  
 *  EX)
 *  검색할 회원번호 입력:
 *  1
 *  1 번 회원은 존재 하지 않습니다.
 *  
 *  
 */
public class MainClass06 {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Scanner keyboard=new Scanner(System.in);
		
		System.out.print("검색할 회원번호 입력: ");
		int num=keyboard.nextInt();
		try {
			conn=new DBConnect().getConn();
			String sql="select num, name, addr"
					+ " from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			// 굳이 while문으로 반복할 필요 x
			// why? select문의 조건 num 은 primary key 이므로 row는 0개 또는 1개 밖에 존재할 수 없다.
			boolean isExist=rs.next();
			if(isExist) {
				String name=rs.getString("name");
				String addr=rs.getString("addr");
				System.out.println("번호 : "+num+", 이름 : "+name+", 주소 : "+addr);
			}
			else {
				System.out.println(num+" 번 회원은 존재하지 않습니다.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
