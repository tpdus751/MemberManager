package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {

	public static void main(String[] args) {
		UpdateTest test = new UpdateTest();
		test.updateMember(3, "4321", "nick003");
	}

	void updateMember(int no, String password, String nickname) {
		// db 연결
		Connection conn = getDBConnection();

		// PS 객체용 변수
		PreparedStatement pstmt = null;

		// sql문
		String sql = new StringBuilder().append("update member ").append("set password=?, nickname=?")
				.append("where no=?").toString();

		try {
			// PS 객체, 매개변수 set
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, nickname);
			pstmt.setInt(3, no);

			// sql 실행~~~~
			int result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
