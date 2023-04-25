package sample06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =
				new ClassPathXmlApplicationContext("sample06/springDIAnnotation.xml");
		
		System.out.println("===================================");
		
		EmpController con = context.getBean("controller", EmpController.class);
		con.test();
	}

}
