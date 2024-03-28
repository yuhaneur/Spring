package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberInsert.do123123")
public class MemberInsertControllerServlet2 extends HttpServlet{
	private MemberService service = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/member/memberForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = (String)req.getParameter("memId");
		String memPass = (String)req.getParameter("memPass");
		String memName = (String)req.getParameter("memName");
		String memRegno1 = (String)req.getParameter("memRegno1");
		String memRegno2 = (String)req.getParameter("memRegno2");
		String memBir = (String)req.getParameter("memBir");
		String memZip = (String)req.getParameter("memZip");
		String memAdd1 = (String)req.getParameter("memAdd1");
		String memAdd2 = (String)req.getParameter("memAdd2");
		String memHometel = (String)req.getParameter("memHometel");
		String memComtel = (String)req.getParameter("memComtel");
		String memHp = (String)req.getParameter("memHp");
		String memMail = (String)req.getParameter("memMail");
		String memJob = (String)req.getParameter("memJob");
		String memLike = (String)req.getParameter("memLike");
		String memMemorial = (String)req.getParameter("memMemorial");
		String memMemorialday = (String)req.getParameter("memMemorialday");
		String mileage = req.getParameter("memMileage");
		Long memMileage = Long.valueOf(mileage); 
		String memDelete = (String)req.getParameter("memDelete");
		
		MemberVO member = new MemberVO();
		member.setMemId(memId);
		member.setMemPass(memPass);
		member.setMemName(memName);
		member.setMemRegno1(memRegno1);
		member.setMemRegno2(memRegno2);
		member.setMemBir(memBir);
		member.setMemZip(memZip);
		member.setMemAdd1(memAdd1);
		member.setMemAdd2(memAdd2);
		member.setMemHometel(memHometel);
		member.setMemComtel(memComtel);
		member.setMemHp(memHp);
		member.setMemMail(memMail);
		member.setMemJob(memJob);
		member.setMemLike(memLike);
		member.setMemMemorial(memMemorial);
		member.setMemMemorialday(memMemorialday);
		member.setMemMileage( memMileage);
		member.setMemDelete(memDelete);
		
		HttpSession session = req.getSession();
		ServiceResult chk = service.createMember(member);
		session.setAttribute("chk", chk);
		session.setAttribute("member", member);
		
		String viewName = "/member/memberList.do";
		resp.sendRedirect(req.getContextPath()+viewName);
	}
}
