package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import web.dao.MemberDAO;
import web.dao.MemberDAOImpl;
import web.dto.Member;

@WebServlet(urlPatterns = "/ajaxTest", loadOnStartup = 1)
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		String key = request.getParameter("key");

		if (key.equals("text")) {
			text(request, response);
		} else if (key.equals("json")) {
			json(request, response);
		} else if (key.equals("dto")) {
			dto(request, response);
		} else if (key.equals("list")) {
			list(request, response);
		} else if (key.equals("map")) {
			map(request, response);
		} else if (key.equals("textJson")) {
			textJson(request, response);
		}
	}

	/**
	 * ajax String 리턴
	 */
	public void text(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print("Welcome to " + name + "님");
	}

	/**
	 * ajax json 리턴
	 */
	public void json(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서비스 호출 -> dao 호출 그 결과 받아서 ajax로

		List<String> menus = Arrays.asList("짜장면", "짬뽕", "탕수육", "우동", "울면");

		// List<>형태를 javaScript로 알 수 있는 json 형태로 변환 - 전용 lib
		Gson gson = new Gson();
		String jsonArr = gson.toJson(menus);

		System.out.println("jsonArr = " + jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	/**
	 * ajax dto 리턴
	 */
	public void dto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member("ayoung166", "조아영", 20, "서울");

		Gson gson = new Gson();
		String jsonArr = gson.toJson(member);

		System.out.println("jsonArr = " + jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	/**
	 * ajax list 리턴
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*List<Member> list = new ArrayList<>();

		list.add(new Member("ayoung166", "조아영", 26, "서울"));
		list.add(new Member("8253jang", "조아영", 26, "서울"));
		list.add(new Member("yeahbbi", "예삐", 20, "서울"));
		list.add(new Member("mini", "미니", 26, "서울"));
		list.add(new Member("naminami", "미남이", 18, "서울"));
		list.add(new Member("duburang", "두부", 23, "서울"));
		list.add(new Member("bean12cong", "콩이", 24, "서울"));*/
		
		MemberDAO dao = new MemberDAOImpl();
		List<Member> list = dao.selectAll();	
		
		Gson gson = new Gson();
		String jsonArr = gson.toJson(list);
		System.out.println(jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	/**
	 * ajax map 리턴
	 */
	public void map(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Ajax Gson Map");
		map.put("pageNo", 10);
		map.put("dto", new Member("ayoung166", "조아영", 26, "서울"));

		List<Member> list = new ArrayList<>();
		list.add(new Member("ayoung166", "조아영", 26, "서울"));
		list.add(new Member("yeahbbi", "예삐", 20, "서울"));
		list.add(new Member("mini", "미니", 26, "서울"));
		list.add(new Member("naminami", "미남이", 18, "서울"));
		list.add(new Member("duburang", "두부", 23, "서울"));
		list.add(new Member("bean12cong", "콩이", 24, "서울"));

		map.put("memberList", list);

		// map을 json으로 변환
		Gson gson = new Gson();
		String jsonArr = gson.toJson(map);
		System.out.println(jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

	/**
	 * ajax textJson 리턴
	 */
	public void textJson(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String addr = request.getParameter("addr");

		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("addr = " + addr);

		// 비즈니스 로직 완료 후 성공 여부에 따라 결과 메세지를 json 형태로 전송
		JsonObject obj = new JsonObject();
		if (name.equals("조아영")) {
			obj.addProperty("info", "success");
		} else {
			obj.addProperty("info", "fail");
		}

		Gson gson = new Gson();
		String jsonArr = gson.toJson(obj);
		System.out.println(jsonArr);

		PrintWriter out = response.getWriter();
		out.print(jsonArr);
	}

}
