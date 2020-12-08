package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass05 {

	public static void main(String[] args) {
		Connection conn=null;
		int num=2;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="delete from member"
					+ " where num=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			flag=pstmt.executeUpdate();
			System.out.println("DELETE 성공");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn!=null) conn.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}
		if(flag>0) {
			System.out.println("작업(Delete) 성공");
		}
		else {
			System.out.println("작업(Delte) 실패");
		}
	}

}
