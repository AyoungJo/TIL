package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/personal/*")
public class LoginFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리 
		HttpServletRequest req =(HttpServletRequest)request;
		
		ServletContext application = req.getServletContext();
		String contextPath = application.getContextPath();
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("udto") == null) {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect(contextPath+"/login.jsp");//폼으로이동
			return;
		}
		
		chain.doFilter(request, response);//실제타켓대상 호출
		//사후처리
	}

	
	public void destroy() {		
		
	}

}
