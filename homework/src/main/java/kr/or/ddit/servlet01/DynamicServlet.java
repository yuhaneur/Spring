package kr.or.ddit.servlet01;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/now.html")
public class DynamicServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date now = new Date(); // data --> 가공 하면 정보 dao
		String info = now.toString(); // information --> 사용자가 이해할수있는 내용으로 만들면 content service
		String content = "<html><body>"+info+"</body></html>"; // content view
		resp.getWriter().println(content);
		
	}
}
