package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraMemberDAO implements MemberDAO {
	public Member selectMember(int no) {
		
		Member member = null;
		
		// DB 연결
		JDBConnection jdbc = new JDBConnection();
						
		// sql문 만들기
		String sql = "select * from member where no=?";

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);
					
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();
					
			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				member = new Member(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("id"),
						jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate")
				);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 자원 객체 닫기
		jdbc.close();
		
		return member;
	}

}
