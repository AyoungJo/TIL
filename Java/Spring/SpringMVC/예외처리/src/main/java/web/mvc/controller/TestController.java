package web.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	/**
	 * 인수로 Model 객체를 전달받으면
	 * Model에 저장된 데이터가 뷰쪽으로 전달된다.
	 * return type이 void, String 인 경우 
	 * 뷰에 전달할 데이터가 필요할 때 쓴다
	 * @param model
	 * @return
	 */
	@RequestMapping("/test2.do")
	public String aa(Model model, String no) {
		//뷰쪽으로 전달될 데이터 저장
		model.addAttribute("message", "test2.do의 요청 결과");

		int convertNo = Integer.parseInt(no);	//NumberFormatException 발생
		
		return "exResult";	//WEB-INF/views/exResult.jsp
	}
}
