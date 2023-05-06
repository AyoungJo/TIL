package web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.mvc.dto.MemberDTO;

@RestController	//@Controller and @ResponseBody. 비동기화 
public class AjaxController {

	/*@RequestMapping(value = "/ajax.do", produces = "text/html; charset=UTF-8")
	public String aa(String id, String pw) {
		System.out.println(id + ", " + pw);
		
		// @RestController로 인해 뷰의 이름이 아닌 응답 객체 (success의 result)
		return "hello안녕"; 
	}*/
	
	@RequestMapping("/ajax.do")
	public List<MemberDTO> aa(String id, String pw) {
		System.out.println(id + ", " + pw);
		
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list.add(new MemberDTO("jo", "ay32@gmail.com", 22, "서울"));
		list.add(new MemberDTO("yeah", "dog@naver.com", 15, "서울"));
		list.add(new MemberDTO("bbibbi", "bowwow@gmail.com", 15, "서울"));
		
		return list;
	}
}
