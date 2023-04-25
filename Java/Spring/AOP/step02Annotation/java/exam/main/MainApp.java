package exam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exam.service.MessageService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springAOP.xml");
		System.out.println("===========================================");
		
		MessageService service = context.getBean("target", MessageService.class);
		
		service.korHello();
		System.out.println("------------------------------------------");

		service.engHello("Hello");
		System.out.println("------------------------------------------");
		
		int re = service.hello();
		System.out.println("re = " + re);
		System.out.println("------------------------------------------");

		String s = service.hello("아영", 20);
		System.out.println("hello() = " + s);
		System.out.println("------------------------------------------");		
		
	}

}
