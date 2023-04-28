package web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;
import web.mvc.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired	
	private ProductService productService;
	
	@RequestMapping("/")
	public String controller(Model model) {

		model.addAttribute("productList", productService.select());			
		return "productList";	//WEB-INF/views/productList.jsp
	}
	
	@RequestMapping("/insertForm")
	public String insertForm() {		
		
		return "insertForm";
	}
	
	@RequestMapping("/insert")
	public String insert(ProductDTO dto) throws MyErrorException {		
		
		productService.insert(dto);		
		
		return "redirect:/";
	}
	
	@RequestMapping("/read")
	public String read(String code, Model model) throws MyErrorException{	
		
		ProductDTO dto =  productService.selectByCode(code);
		model.addAttribute("product", dto);	
		
		return "read";
	}
	
	@RequestMapping("/delete")
	public String delete(String code, Model model) throws MyErrorException {		
		
		productService.delete(code);
		
		return "redirect:/";
	}
	
	@ExceptionHandler(value = {MyErrorException.class})
	public String error(Exception e, Model model) {
		
		model.addAttribute("errMessage", e.getMessage());
		
		return "error";
	}
	
}
