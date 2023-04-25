package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// 기존 방식
		/*StudentDAO dao = new StudentDAOImpl(); //bean
		
		Student student = new Student();
		student.setName("아영");
		student.setAddr("서울");
		student.setNo(10);
		student.setPhone("111-1234");		
		
		StudentServiceImpl service = new StudentServiceImpl(); //bean
		service.setStudentDAO(dao);
		
		StudentController controller = new StudentController(); //bean
		controller.setService(service);
		controller.setStudent(student);
		
		controller.insert();*/	//호출
		
		////////////////////////////////////////////
		ApplicationContext context = new ClassPathXmlApplicationContext("sample04/springDISetter.xml");
		
		System.out.println("=========================================");
		StudentController con = context.getBean("controller", StudentController.class);
		con.insert();
	}

}
