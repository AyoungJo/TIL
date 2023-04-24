package sample02;

public class Member {

	private String id;
	private String pwd;
	private int age;
	private String addr;
	
	public Member() {
		System.out.println("Member() 기본 생성자 호출");
	}
	
	public Member(String id) {
		this.id = id;
		System.out.println("Member(String id) 호출");
	}
	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		System.out.println("Member(String id, String pwd) 호출");
	}
	public Member(String id, int age) {
		this.id = id;
		this.age = age;
		System.out.println("Member(String id, int age) 호출");
	}
	public Member(String id, int age, String addr) {
		this.id = id;
		this.age = age;
		this.addr = addr;
		System.out.println("Member(String id, int age, String addr) 호출");
	}
	public Member(String id, String pwd, int age, String addr) {
		this.id = id;
		this.pwd = pwd;
		this.age = age;
		this.addr = addr;
		System.out.println("Member(String id, String pwd, int age, String addr) 호출");
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", age=" + age + ", addr=" + addr + "]";
	}
	
	
}
