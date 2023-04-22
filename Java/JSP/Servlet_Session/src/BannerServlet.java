package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.BannerService;
import service.BannerServiceImpl;

@WebServlet(urlPatterns = "/banners", loadOnStartup = 1)
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		
		BannerService bs = new BannerServiceImpl();
		List<String> list = bs.listBanner();
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("banners", list);
		
		Gson gson = new Gson();
		
		String jsonArr = gson.toJson(map);
		System.out.println(jsonArr);

		response.getWriter().print(jsonArr);
	}       
}
