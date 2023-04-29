package web.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;
import web.mvc.service.ProductService;

@Controller
@RequiredArgsConstructor //final 필드 or @NonNull을 선언한 필드를 기반으로 생성자 생성
public class ProductController {
	
	/*@Autowired	
	//byType으로 주입 (ProductService 타입 1개) -> 주입이 안될
	private ProductService productService;*/
	
	//↑ @Autowired 사용하지 않고 
	//↓ lombok에 있는 @RequiredArgsConstructor 를 사용하고 
	//final 필드 선언하여 주입
	
	//final - 값 변경 불가, 반드시 초기화 필수(생성자를 이용) -> 반드시 주입
	private final ProductService service;

	@RequestMapping("/")
	public String controller(Model model) {

		List<ProductDTO> list = service.select();
		model.addAttribute("productList", list);			
		return "productList";	//WEB-INF/views/productList.jsp
	}

	@RequestMapping("/insertForm")
	public String insertForm() {		
		
		return "insertForm";
	}
	
	@RequestMapping("/insert")
	public String insert(ProductDTO dto) throws MyErrorException {		
		
		service.insert(dto);		
		
		return "redirect:/";
	}
	
	@RequestMapping("/read")
	public String read(String code, Model model) throws MyErrorException{	
		
		ProductDTO dto =  service.selectByCode(code);
		model.addAttribute("product", dto);	
		
		return "read";
	}
	
	/**
	 * 삭제하기 1
	 */
	/*@RequestMapping("/delete")
	public String delete(String code, Model model) throws MyErrorException {		
		
		service.delete(code);
		
		return "redirect:/";
	}*/
	
	/**
	 * 삭제하기 2
	 */
	@RequestMapping("/delete/{code}")
	public String delete(@PathVariable String code) throws MyErrorException {		
		
		service.delete(code);
		
		return "redirect:/";
	}
	
	@ExceptionHandler(MyErrorException.class)
	public String error(Exception e, Model model) {
		
		model.addAttribute("errMessage", e.getMessage());
		
		return "error";
	}

}
