package Customer;

public class Customer {
	private String id;
	private int age;
	private String addr;

	public Customer() {
	}

	public Customer(String id, int age, String addr) {
		// 생성자 호출방법 - this(값,...) 반드시 생성자 구현부 첫번째 줄에서만
		this(id, age);
		this.addr = addr;
	}

	public Customer(String id, int age) {
		this.id = id;
		this.age = age;
	}

	public String getId() {
		return id + "님";
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age > 18)
			this.age = age;

	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
