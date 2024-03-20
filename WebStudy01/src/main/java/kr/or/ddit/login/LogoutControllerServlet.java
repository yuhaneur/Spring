package kr.or.ddit.login;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/logout.do")
public class LogoutControllerServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 현재 사용자의 세션 즉시 만료.
		//req.getSession(true); // 아직 세션이 없으면 그즉시 세션을 만들어라 == req.getSession();
		HttpSession session = req.getSession();
		if(session.isNew()) {// true -> 최초요청
			resp.sendError(400,"현재 요청이 최초의 요청일 수 없음.");
			return;
		}
//		String user = req.getParameter("authId");
//		System.out.println(user);
//		session.removeAttribute(user);
		session.invalidate();
		
		String message = "로그아웃 성공.";
		// 웰컴 페이지로 이동.
		message = URLEncoder.encode(message, "UTF-8");
		resp.sendRedirect(req.getContextPath()+"/?message="+message);
	}
}
