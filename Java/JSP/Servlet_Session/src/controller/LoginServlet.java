package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;
import service.LoginService;
import service.LoginServiceImpl;

@WebServlet(urlPatterns = {"/login","/logout"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 로그인
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String email = request.getParameter("email");
		String pw = request.getParameter("pass");
		
		System.out.println("email = " + email);
		System.out.println("password = " + pw);
		
		LoginService service = new LoginServiceImpl();		
		UserDto udto = service.login(email, pw);	//로그인한 사용자 email, pw
		
		String result = "fail";	// data
		if(udto != null) {
			result = "success";
			
			//로그인 성공이니 session에 사용자 정보 저장
			HttpSession session = request.getSession();
			session.setAttribute("udto", udto); //뷰에서 ${sessionScope.udto} 가능
			System.out.println("udto = " + udto);
			//response.sendRedirect("index.jsp");
		}
		
		Gson gson = new Gson();
		JsonObject obj = new JsonObject();
		obj.addProperty("result", result);	//로그인 성패 결과
		
		String jsonArr = gson.toJson(obj);
		System.out.println("jsonArr = " +jsonArr);
		
		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	/**
	 * 로그아웃
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//모든 세션 정보 정리 삭제
		request.getSession().invalidate(); //모든 세션 정보 제거		
		response.sendRedirect("index.jsp");
	
	}

}
