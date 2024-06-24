package member;

import java.util.List;

public class MemberService {
	
	private MemberDAO memberDao;
	
	public MemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public boolean regist(Member member) {
		int result = memberDao.insertMember(member);
		
		return (result == 1) ? true : false;
	}
	
	public Member read(int no) {
		Member member = memberDao.selectMember(no);
		return member;
	}
	
	public List<Member> listAll() {
		
		List<Member> memberList = memberDao.selectMemberAll();
		return memberList;
	}
	
	public boolean edit(Member member, String oldPassword) {
		
		if (member == null) return false;
		if (oldPassword == null) return false;
		
		int result = 0;
		
		Member memInfo = memberDao.selectMember(member.getNo());
		if (oldPassword.equals(memInfo.getPassword())) {
				result = memberDao.updateMember(member);
		}
		
		return (result == 1) ? true : false;
	}
	
	public boolean remove(int no) {
		if (memberDao.selectMember(no) == null) {
			return false;
		}
		
		int result = memberDao.deleteMember(no);
		
		return (result == 1) ? true : false;
	}
}
