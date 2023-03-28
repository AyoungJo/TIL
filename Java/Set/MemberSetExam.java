package ex0327.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam extends Member {
	private Set<Member> set = new HashSet<>();

	public MemberSetExam() {
		/**
		 * Set의 중복 체크 hashcode()메소드를 호출해서 리턴 값이 다르면 다른 객체, 같으면 equlas()메소드를 호출해서 true면
		 * 같은 객체, false면 다른 객체
		 */
		// 3개 저장
		set.add(new Member("조아영", 26, "서울"));
		System.out.println("--------------------------");
		set.add(new Member("조아영", 26, "충주"));
		System.out.println("--------------------------");
		set.add(new Member("조아영", 23, "대구"));
		System.out.println("--------------------------");

		System.out.println("저장된 객체의  개수 : " + set.size());
	}

	public static void main(String[] args) {
		new MemberSetExam();

	}

}
