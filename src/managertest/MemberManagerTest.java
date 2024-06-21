package managertest;

import member.Member;
import member.OraMemberDAO;
import member.MemberDAO;

public class MemberManagerTest {

	public static void main(String[] args) {
		MemberDAO memberDao = new OraMemberDAO();
		Member member = memberDao.selectMember(3);
		if (member != null) {
			System.out.println(member.toString());
		}

	}

}
