package web.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/param")
public class ParameterController {

	@RequestMapping("/a.do")
	String aa(String name, Integer age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		return "result";
	}
	
	/**
	 * @return void는 요청주소가 뷰 이름이 된다.
	 * /WEB-INF/views/params/b.jsp
	 **/
	@RequestMapping("/b.do")
	public void bb(@RequestParam(defaultValue = "Guest") String id, 
			@RequestParam(defaultValue = "0") int age) {
		
		System.out.println("id  = " + id);
		System.out.println("age  = " + age);	
	}

	//parameter명과 인수명이 같지 않을 때 바인딩하는것
	@RequestMapping("/c.do")
	public String cc(@RequestParam(value = "userId") String id) {
		System.out.println("id = " + id);
		return "result";	
	}
	
	/**
	 * 인수로 객체타입(DTO)를 받으면
	 * 전달된 객체가 뷰 쪽으로 전달된다.
	 * 뷰에서 표현언어를 이용하여 사용할 수 있다.
	 * 객체 이름의 첫글자만 소문자로 접근
	 * ex) ${memerDTO.속성}
	 * 
	 * 인수에 @ModelAttribute 선언하면 객체 별칭을 만든다
	 * 뷰에서 ${dto.속성}
	 */
	@RequestMapping("/user.do")
	public ModelAndView user(@ModelAttribute("dto") MemberDTO dto ) {
		
		System.out.println("dto = " + dto);
		return new ModelAndView("ok"); //WEB-INF/views/ok.jsp
	}
	
	@ModelAttribute("hobbys")	//뷰에서 ${hobbys} 사용
	public List<String> hobbys(){
		return Arrays.asList("골프","낚시","수영","축구","먹방");
	}
	
	@ModelAttribute("info")	//뷰에서 ${hobbys} 사용
	public String info(){
		return "Spring MVC";
	}
	
}
