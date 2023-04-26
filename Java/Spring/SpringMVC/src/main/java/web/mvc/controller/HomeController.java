package web.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller //xml에서 <bean class="HomeController" 동일
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping("/test.do")
	public ModelAndView home() {
		System.out.println("test.do 요청");
		
		return new ModelAndView("home");	//WEB-INF/views/home.jsp 이동
	}
	
}
