package sample02;

public class MemberService {

	private MemberDAO memberDAO;
	private Member member;
	
	public MemberService() {
		System.out.println("MemberService ()");
	}

	public MemberService(MemberDAO memberDAO, Member member) {
		this.memberDAO = memberDAO;
		this.member = member;
		System.out.println("MemberService(MemberDAO memberDAO, Member member)");
		System.out.println("memberDAO = " + memberDAO);
		System.out.println("member = " + member);
	}
	
	public void serviceInesert() {
		System.out.println("MemberService의 serviceInesert()");
		memberDAO.insert(member);
	}
	
	
}
