import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {

		List<Employee> emp = new ArrayList<>();

		emp.add(new FullTime(10, "유재석", "개그우먼", 0, "2013-05-01", "무한도전", 8500, 200));
		emp.add(new FullTime(20, "박명수", "가수", 10, "2013-06-20", "무한도전", 7500, 100));
		emp.add(new FullTime(30, "정준하", "예능인", 10, "2013-06-22", "무한도전", 6000, 0));

		emp.add(new PartTime(40, "노홍철", "예능인", 20, "2014-05-01", "무한도전", 20000));
		emp.add(new PartTime(50, "하하", "가수", 30, "2014-05-02", "무한도전", 25000));

		for (Employee e : emp) {
			System.out.println(e);
		}

		System.out.println("------ 메시지 출력 ------");
		for (Employee e : emp) {
			e.message();
		}

	}

}
