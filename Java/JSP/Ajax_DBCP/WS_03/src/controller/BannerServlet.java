package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.BannerService;
import service.BannerServiceImpl;


/**
 * Servlet implementation class BannerServlet
 */
@WebServlet(urlPatterns = "/banners", loadOnStartup = 1)
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String key = request.getParameter("key");
		if(key.equals("banner")){
			doGet(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BannerService bs = new BannerServiceImpl();
		List<String> list = bs.listBanner();
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(list);
		System.out.println(jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}
       
}
