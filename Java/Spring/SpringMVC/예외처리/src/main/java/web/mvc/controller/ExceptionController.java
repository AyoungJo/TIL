package web.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	@RequestMapping("/exception.do")
	public ModelAndView ex(String no) {
		//System.out.println("exceptionn.do 요청");
		logger.info("no = " + no);
		
		int convertNo = Integer.parseInt(no);
		int result = 100 / convertNo;	//ArithmeticException
		
		logger.info("exception.do 요청, convertNo = " + convertNo);
		
		//viewName : exResult.jsp
		// WEB-INF/views/exResult.jsp이동 하며 
		//${requestScope.message}를 뷰로 전달
		return new ModelAndView("exResult", "message", "예외 처리 결과");
	}
	
	/**
	 * 현재 컨트롤러 실행시 발생하는 예외처리
	 * 해당 어노테이션에 value 값 지정시 직접 처리 / 간접 처리 보다 먼저 수행
	 */
	@ExceptionHandler(value = {ArithmeticException.class} )
	public ModelAndView error(Exception e) {
		logger.info("Exception 예외 발생");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorMessage");	//WEB-INF/views/error/errorMessage.jsp 이동
		mv.addObject("errmsg", "예외 발생");		//${errMsg}
		mv.addObject("errClass", e.getMessage());	
		
		return mv;
	}

}
