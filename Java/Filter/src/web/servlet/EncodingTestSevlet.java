package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/encTest")
public class EncodingTestSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		System.out.println(name);
		
		//개인 추가 코드
		PrintWriter out = response.getWriter();		
		out.print("<html>");
		out.print("<head><title>Servlet Test</title></head>");
		out.print("<body>");
		out.print("<h3> 이름 : " + name + "</h3>");
		out.print("</body>");
		out.print("</html>");
	}

}
