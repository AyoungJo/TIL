package sample04;

public class Student {
   private String name;
   private int no;
   private String phone;
   private String addr;
   
   public Student() {
	   System.out.println("Student 기본생성자 call.....");
   }

	public void setName(String name) {
		this.name = name;
		System.out.println("Student 의 setName(String name)  호출  name = " + name);
	}
	
	public void setNo(int no) {
		this.no = no;
		System.out.println("Student 의 setNo(int no)  호출  no = " + no);
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("Student 의 setPhone(String phone)  호출  phone = " + phone);
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println("Student 의 setAddr(String addr)  호출  addr = " + addr);
	}
   
    @Override
	public String toString() {
		return name +" | " + no +" | " + phone +" | " + addr;
	}
}
