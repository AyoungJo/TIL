package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter(urlPatterns = {"/encodingResult.jsp","/encTest"})
//@WebFilter(urlPatterns = {"/*"})
//@WebFilter(urlPatterns = {"*.jsp"})
@WebFilter(urlPatterns = {"/user/*","/admin/*"})
public class EncodingFilter implements Filter {

    public EncodingFilter() {
    	System.out.println("EncodingFilter() 생성자 호출");
    }
    
	public void init(FilterConfig fConfig) throws ServletException {
    	System.out.println("init() 호출");
	}
	
	public void destroy() {
    	System.out.println("destroy() 호출");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/* @WebFilter("/encodingResult.jsp") 요청될 때 실행 */

		System.out.println("사전처리 입니다.");
		
		request.setCharacterEncoding("UTF-8"); //post방식 한글 인코딩
		
		//request 인코딩 처리가 된 후 보내주기 때문에 인코딩 반복 코드 줄일 수 있음
		chain.doFilter(request, response); //다음 Filter Target 호출 
		
		System.out.println("사후처리 입니다.");
	}


}
