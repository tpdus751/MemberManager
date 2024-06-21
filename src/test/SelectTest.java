package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {
		SelectTest test = new SelectTest();
		//test.selectAllMember();
		test.selectMember(1);
	}
	
	public void selectMember(int no) {
		// DB 연결
		Connection conn = getDBConnection();

		// PreparedStatement 변수, ResultSet 변수 선언
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		// sql문 만들기
		String sql = "select * from member where no=?";

		try {
			
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			// SQL문 실행
			rs = pstmt.executeQuery();
			
			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (rs.next()) {
				System.out.print(rs.getInt("no") + "\t");
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("password") + "\t");
				System.out.print(rs.getString("nickname") + "\t");
				System.out.println(rs.getString("regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 자원 객체 닫기
	}

	public void selectAllMember() {
		// DB 연결
		Connection conn = getDBConnection();

		// PreparedStatement 변수, ResultSet 변수 선언
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// sql문 만들기
		String sql = "select * from member";

		try {
			// PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			// SQL문 실행
			rs = pstmt.executeQuery();
			
			// ResultSet 객체에서 결과값 가져와서 출력하기
			while (rs.next()) {
				System.out.print(rs.getInt("no") + "\t");
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("password") + "\t");
				System.out.print(rs.getString("nickname") + "\t");
				System.out.println(rs.getString("regdate"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 자원 객체 닫기
	}

	Connection getDBConnection() {
		// DB 연결을 위한 정보
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##java";
		final String passwd = "1234";

		// DB 연결 객체 생성하여 반환
		Connection conn = null;

		try {
			// JDBC 드라이버 loading
			Class.forName(jdbcDriverClassName);

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, userid, passwd);
			System.out.println("오라클 DB 연결 성공");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
