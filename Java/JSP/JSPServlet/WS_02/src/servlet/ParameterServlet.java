package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/params")
@WebServlet(urlPatterns = "/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");

		// 파라미터 처리하기
		String job = request.getParameter("job");	
		String pageNo = request.getParameter("pageNo");		
		String searchWord = request.getParameter("searchWord");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("job",job);
		map.put("pageNo",pageNo);
		map.put("searchWord",searchWord);
		
		request.setAttribute("map", map);
		
		request.getRequestDispatcher("getResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8"); // need with POST
		response.setContentType("text/html; charset=utf-8");
		
		// 파라미터 처리하기
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		String hobby[] = request.getParameterValues("hobby");
		StringBuilder sbHobby = new StringBuilder();
		for (String h : hobby) {
			sbHobby.append(h).append(", ");
		}
		sbHobby.setLength(sbHobby.length()-2);
		
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");

		ParameterDto pd = new ParameterDto(name, email, gender, hobby, favorite, desc);
		
		request.setAttribute("pd", pd);
		
		request.getRequestDispatcher("postResult.jsp").forward(request, response);

	}

}
