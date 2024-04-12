package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.hr.vo.MemberVO;

/**
 * C : /member/memberInsert.do(GET, POST)
 * R (GET)
 * 단건 : /member/memberDetail.do?who=a001
 * 다건 : /member/memberList.do
 * U : /member/memberUpdate.do(GET,POST)
 * D : /member/memberDelete.do(POST)
 *
 */
@WebServlet("/member/memberList.do")
public class MemberListControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MemberVO> memList = service.retrieveMemberList();
		req.setAttribute("memList", memList);
		
		HttpSession session = req.getSession();
		ServiceResult chk =  (ServiceResult) session.getAttribute("chk");
		String viewName = "";
		if(chk==ServiceResult.FAIL) {
			viewName = "/member/memberInsert.do";
		}
		
		viewName = "/WEB-INF/views/member/memberList.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	
}
