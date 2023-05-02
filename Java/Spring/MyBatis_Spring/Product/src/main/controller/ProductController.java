package web.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import web.mvc.dto.ProductDTO;
import web.mvc.service.ProductService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/")
	public String index() {
		return "index"; //WEB-INF/views/index.jsp�̵
	}
	
	@RequestMapping("/form/{url}")
	public void url() {}
	
	/**
	 * 1.레코드 삽입
	 * */
	@RequestMapping("/insert")
	public String insert(ProductDTO productDTO) {
		productService.insert(productDTO);
		return "redirect:/selectAll";
	}	
	
	/**
	 * 2. 전체검색
	 * */
	@RequestMapping("/selectAll")
	public ModelAndView selectAll() {
		//서비스 호출
		List<ProductDTO> list = productService.selectAll();
		return new ModelAndView("selectResult","productList", list);
	}	
	
	/**
	 * 3. 검색필드 , 검색단어에 해당하는 레코드 검색
	 * */
	@RequestMapping("/selectByWord")
	public ModelAndView selectByKeyWord(String keyField, String keyWord) {
		List<ProductDTO> list = productService.selectByKeyWord(keyField, keyWord);
	    return new ModelAndView("selectResult","productList", list);
	}
	
	/**
	 * 4. 정렬대상 컬럼을 인수로 받아 정렬
	 * */
	@RequestMapping("/selectByOrder")
	public ModelAndView selectByOrder(String columnName) {
		List<ProductDTO> list = productService.selectOrder(columnName);
		return new ModelAndView("selectResult", "productList",list);
	}

	/**
	 * 5. 파라미터 값을 받아 업데이트하기
	 * */
	@RequestMapping("/update")
	public String update(ProductDTO productDTO) {
		productService.update(productDTO);		
	    return "redirect:/selectAll";
	}
	
	/**
	 * 6.삭제하기
	 * */
	@RequestMapping("/delete")
	public String delete(String code) {
		productService.delete(code);
		return "redirect:/selectAll";	
	}	
		
	/**
	 * 7. qty 전체 개수 구하기
	 * */
	@RequestMapping("/totalCount")
	public String totalCount(Model model) {
		int count = productService.selectSumQty();
		model.addAttribute("totalCount", count);
	    return "countResult";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView error(Exception e) {
		return new ModelAndView("error","erMsg",e.getMessage());
	}
	
	
}
