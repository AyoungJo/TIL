package ex0328.singleton;

/**
 * Singleton
 */
class Test {
	// ② 외부에서 직접 접근 불가(private), static끼리 접근 하기 위함(static)
	private static Test instance = new Test();

	// 외부에서 직접 객체 생성 못하도록 함
	private Test() {

	}

	/**
	 * 현재 객체내에서 자신을 생성해서 리턴해주는 메소드 제공
	 */
	public static Test getInstance() {
		// Test instance = new Test(); //객체 생성하지 않고도 접근할 수 있도록 static으로 선언①
		return instance;

	}
}

public class TestMainApp {

	public static void main(String[] args) {
		// new Test();
		Test t1 = Test.getInstance();
		Test t2 = Test.getInstance();
		Test t3 = Test.getInstance();

		// ① t1, t2, t3가 모두 다른 주소값을 가지고 있음(모두 다른 객체)
		// ② t1, t2, t3가 모두 같은 주소값을 가지고 있음(모두 같은 객체)
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
	}

}
