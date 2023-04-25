package sample02;

public class MemberDAO {
	
	public MemberDAO() {
		System.out.println("MemberDAO()");
	}

	public void insert(Member member) {
		System.out.println("insert()");
		System.out.println("member = " + member);
	}
}
