package Customer;

public class CustomerMain {

	public static void main(String[] args) {
		Customer[] cuArr = new Customer[3];

		cuArr[0] = new Customer(); // 기본값 초기화
		cuArr[1] = new Customer("Jo", 20, "서울"); // 모든 필드 초기화
		cuArr[2] = new Customer("kim", 30);

		// 출력
		for (Customer c : cuArr) {
			System.out.print("아이디 : " + c.getId() + "\t");
			System.out.print("나이 : " + c.getAge() + "\t");
			System.out.print("주소 : " + c.getAddr() + "\n");
		}

		// 나이변경
		cuArr[0].setAge(25);
		System.out.println("-변경후 출력 ---------");
		for (Customer c : cuArr) {
			System.out.print("아이디 : " + c.getId() + "\t");
			System.out.print("나이 : " + c.getAge() + "\t");
			System.out.print("주소 : " + c.getAddr() + "\n");
		}

	}

}

