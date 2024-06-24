package managertest;

import java.util.List;

import member.Member;
import member.MemberDAO;
import member.MemberService;
import member.MemberDAO;

public class MemberManagerTest {

	public static void main(String[] args) {
		MemberService service = new MemberService(new MemberDAO());
		Member member;
		
		// 회원 등록
		member = new Member("test2402", "1234", "nick2402");
		if (service.regist(member)) {
			System.out.println("회원을 등록하였습니다.");
		} else {
			System.out.println("회원 등록에 실패했습니다.");
		}
		
		// 회원 수정
		member = new Member(10, null, "4321", "nick004", null);
		service.edit(member, "p001");
		
		// 회원 삭제
		service.remove(3);
		
		// 회원 목록 보기
		
		List<Member> memberList = service.listAll();
		for (Member mem : memberList) {
			System.out.println(mem.toString());
		}
		
		// 회원 조회
		member = service.read(5);
		if (member != null) {
			System.out.println(member.toString());
		}
	}

}
