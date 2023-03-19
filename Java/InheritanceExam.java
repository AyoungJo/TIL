class Car {
	public String carname;
	public int cost;

	protected void printAttributes() {
		System.out.println("carname=" + carname + "\tcost=" + cost);
	}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
// 각 클래스에 인수를 받지않는 생성자 작성
// 각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당

class EfSonata extends Car {
	EfSonata() {
		this.carname = "EfSonata";
		cost = 2500;
	}
}

class Excel extends Car {
	Excel() {
		super.carname = "Excel";
		super.cost = 1000;
	}
}

class Carnival extends Car {
	int a = 100;

	Carnival() {
		this.carname = "Carnival";
		cost = 4000;
	}
}

public class InheritanceExam {
	public static void main(String[] args) {
		Car car = new Car();
		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();

		System.out.println("car = " + car);// 주소값 : 클래스이름@hashcode
		System.out.println("ef = " + ef);
		System.out.println("ca = " + ca);
		System.out.println("ex = " + ex);

		System.out.println("**********************************");
		car.printAttributes();
		ef.printAttributes();
		ca.printAttributes();
		ex.printAttributes();
	}

}
