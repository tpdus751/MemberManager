package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnTest {

	public static void main(String[] args) {
		DBConnTest test = new DBConnTest();
		Connection conn = test.getDBConnection();
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
