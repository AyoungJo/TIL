package sample07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("sample07/springDIAnnotation.xml");
		System.out.println("=========================================");
		BoardController controller = context.getBean("boardController", BoardController.class);
	
		controller.test();
	}

}
