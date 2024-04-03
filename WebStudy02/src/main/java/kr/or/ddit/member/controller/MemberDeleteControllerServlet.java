package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteControllerServlet extends HttpServlet {
	private MemberService service = new MemberServiceImpl();// 의존관계

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 * 1. 요청 접수, 분석
		HttpSession session = req.getSession();
//		 * 2. 검증
		if (session.isNew()) {
			resp.sendError(400);
			return;
		}
		MemberVO authMember = (MemberVO) session.getAttribute("authMember");
		String viewName = null;
		if (authMember == null) {
			viewName = "redirect:/login/loginForm.jsp";
		} else {
			String memId = authMember.getMemId();
			String password = req.getParameter("password");
			if (StringUtils.isBlank(password)) {
				resp.sendError(400);
				return;
			}
//				3.로직사용
			MemberVO inputData = new MemberVO();
			inputData.setMemId(memId);
			inputData.setMemPass(password);
			ServiceResult result = service.removeMember(inputData);
//				4.로직으로부터 확보한 모델을 공유
			switch (result) {
			case INVALIDPASSWORD:
				session.setAttribute("message", "비밀번호 오류");
				viewName = "redirect:/mypage";
				break;
			case FAIL:
				session.setAttribute("message", "서버 오류! 잠시 뒤 다시 탈퇴하세요");
				viewName = "redirect:/mypage";
				break;
			default:
				viewName = "forward:/login/logout.do";
				break;
			}

//				 6. view로 이동(flow control)
			if (viewName.startsWith("redirect:")) {
				String location = viewName.replace("redirect:", req.getContextPath()); // prefix 이 규칙은 나중에 Spring에서 그대로
																						// 사용됨!!!!
				resp.sendRedirect(location);
			}else if(viewName.startsWith("forward:")) {
				String path = viewName.substring("forward:".length());
				req.getRequestDispatcher(path).forward(req, resp);
			}else {
				req.getRequestDispatcher(viewName).forward(req, resp);
			}
		}
	}
}
