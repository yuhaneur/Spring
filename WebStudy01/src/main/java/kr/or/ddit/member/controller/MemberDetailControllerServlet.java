package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDetail.do")
public class MemberDetailControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId=Optional.ofNullable(req.getParameter("who"))
							 .filter(mem->!mem.isEmpty())
							 .orElseThrow(()->new PkNotFoundException(500));
		MemberVO memVo =  service.retrieveMember(memId);
		req.setAttribute("memVo", memVo);
		
		String viewName = "/jsonView.do";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
