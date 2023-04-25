package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * BookDAO dao = new BookDAOImpl(); BookVo bookVo = new
		 * BookVo("spring","조아영",25000,"2023-04-24");
		 * 
		 * BookController controller = new BookController(dao, bookVo);
		 * controller.bookInsert();
		 */
		
		ApplicationContext context 
				= new ClassPathXmlApplicationContext("sample03/bookDI.xml");
		
		BookController con =  context.getBean("con", BookController.class);
		con.bookInsert();
	}

}
