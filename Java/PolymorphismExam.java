class CarCenter {
	// 매개변수를 이용한 다형성
	public void engineer(Car cd) { // Car cd = ex;
		System.out.println("cd = " + cd);
		// System.out.println(cd.a);//에러(부모는 자식 접근불가)
		// 접근이 가능하도록 하기 위해서는 ObjectDownCasting
		if (cd instanceof Carnival) { // 상속관계일때만 사용가능
			Carnival efs = (Carnival) cd; // 부모 > 자식 -> ObjectDownCasting
			System.out.println("efs = " + efs);
			System.out.println("efs.a = " + efs.a);
		}

		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");

	}

}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();

		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();
		Car car = new Car();

		System.out.println("ca = " + ca);
		System.out.println("ca.a = " + ca.a);

		// cc.engineer(ca);

		cc.engineer(car);
		cc.engineer(ef);
		cc.engineer(ca);
		cc.engineer(ex);

	}
}
