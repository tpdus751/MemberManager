package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBConnection {

	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;

	public JDBConnection() {
		// DB 연결을 위한 정보
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userid = "c##java";
		final String passwd = "1234";

		try {
			// JDBC 드라이버 loading
			Class.forName(jdbcDriverClassName);

			// Connection 객체 생성
			conn = DriverManager.getConnection(url, userid, passwd);
			System.out.println("오라클 DB 연결 성공");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
