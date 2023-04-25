package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//기존 방식
		/*
		 * Member member = new Member("joy","1234",23,"서울"); 
		 * MemberDAO dao = new MemberDAO(); 
		 * MemberService service = new MemberService(dao, member);
		 * 
		 * service.serviceInesert();
		 */
		
		//사전초기화에 의해 Member 클래스의 기본 생성자 호출
		ApplicationContext context 
				= new ClassPathXmlApplicationContext("sample02/springDI.xml");
		
		System.out.println("====================================");
		MemberService service = context.getBean("service", MemberService.class);
		service.serviceInesert();		
				
	}

}
