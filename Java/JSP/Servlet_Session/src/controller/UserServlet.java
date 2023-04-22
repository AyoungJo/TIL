package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UserDto;
import service.UserService;
import service.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입
		String job = request.getParameter("job");
		switch(job) {
		   case "register" : 
			   register(request,response); 
			   break;		   
		}
	}
	
	/**
	 * 가입하기
	 * */
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //폼으로 전송된 데이터 받기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		UserDto udto = new UserDto(0, name, password, email, phone, false);
		System.out.println("udto = " + udto);
		
		UserService service = UserServiceImpl.getInstance();
		int result = service.register(udto);
		
		response.getWriter().print(result);
	}
	
	/**
	 * 비밀번호변경 - 추가 예정
	 */

}
