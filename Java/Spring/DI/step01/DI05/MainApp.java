package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample04.StudentController;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample05/orderDI.xml");
		
		System.out.println("=========================================");
		OrderMessage order = context.getBean("msg", OrderMessage.class);
		order.getOrderMessage();
	}

}
