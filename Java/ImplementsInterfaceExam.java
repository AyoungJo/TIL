package ex0327.interfaceEx;

/**
 * 에러가 나는 부분 알맞게 수정하기 interface의 모든 변수는 public static final interface의 모든
 * method는 public abstract class가 interface를 implements하게 되면 interface에 있는 모든
 * method 재정의해야 한다. 재정의 안 하면 abstract class로 선언되어야 한다.
 * 
 */

public class ImplementsInterfaceExam {
	public static void main(String args[]) {
		// 다형성 , 재정의된 메소드만 사용 가능 
		SubClassExam02 sub02sub04 = new SubClassExam04("SubClassExam02", "sub02sub04");
		SuperClassExam superSub04 = new SubClassExam04("SuperClassExam", "superSub04");
		InterfaceExam01 ifc01Sub04 = new SubClassExam04("InterfaceExam01", "ifc01Sub04");
		SubClassExam04 sub04 = new SubClassExam04();

		sub04.interfaceExam00();
		sub04.interfaceExam01(1, 7);
		sub04.superMethod();
	}
}

interface InterfaceExam00 {
	abstract void interfaceExam00();
}

interface InterfaceExam01 extends InterfaceExam00 {
	final int i = 767;

	// private int k = 999;
	public int k = 999;

	void interfaceExam01(int i, int k);
}

interface InterfaceExam02 {
	int j = 747;

//	protected int privateInt = 8; 
	public static final int privateInt = 8;

	public abstract void interfaceExam02(int j);

}

class SuperClassExam {
	String superString = "Super";

	String superMethod() {
		System.out.println("SuperClassExam.SuperMethod()가 호출되었습니다.");
		return "returnString";
	}
}

class SubClassExam01 extends SuperClassExam implements InterfaceExam01 {

	// 부모 보다 접근제한자가 크거나 같아야 한다
	@Override
	public void interfaceExam00() {

	}

	@Override
	public void interfaceExam01(int i, int k) {

	}
}

/* abstract */ class SubClassExam02 extends SuperClassExam implements InterfaceExam01, InterfaceExam02 {

	@Override
	public void interfaceExam00() {

	}

	@Override
	public void interfaceExam02(int j) {

	}

	@Override
	public void interfaceExam01(int i, int k) {
	}

}

abstract class SubClassExam03 extends SuperClassExam implements InterfaceExam01, InterfaceExam02 {
}

class SubClassExam04 extends SubClassExam02 {
	public void interfaceExam00() {
	}

	public void interfaceExam01(int i, int k) {
	}

	public void interfaceExam02(int j) {
	}

	SubClassExam04() {
		System.out.println("subClassExam04() 객체 생성");
		System.out.println(" i = " + i);
		System.out.println(" j = " + j);
	}

	SubClassExam04(String s1, String s2) {
		System.out.println(s1 + " 타입 " + "subClassExam04(" + s2 + ") 객체 생성");

	}

	void printSuperString() {
		InterfaceExam01 ie01 = new InterfaceExam01() {

			@Override
			public void interfaceExam00() {

			}

			@Override
			public void interfaceExam01(int i, int k) {

			}
		};

		System.out.println(" superString = " + superString);
	}
}
