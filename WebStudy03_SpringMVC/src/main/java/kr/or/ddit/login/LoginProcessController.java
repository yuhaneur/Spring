package kr.or.ddit.login;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import kr.or.ddit.login.service.AuthenticateSerivce;
import kr.or.ddit.vo.MemberVO;

@Controller
public class LoginProcessController  {
	@Autowired
	private AuthenticateSerivce service ;
	
	private boolean authenticate(String id, String password) { //authenticate : 인증하다
		return id.equals(password);
	}
	
	@PostMapping("/login/loginProcess.do")
	public String login(
			Model model
			,@RequestParam String memId
			,@RequestParam String memPass
			,HttpServletRequest req, HttpServletResponse resp) {
		 HttpSession session = req.getSession(false); //최초의 요청이 아니라 id가 없을수 없음!
		if(session.isNew()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "로그인을 하려면 로그인 폼이 먼저 최초의 요청으로 전송되었어야 함.");
		}
		String viewName = null;
		try {
			MemberVO inputData = new MemberVO();
			inputData.setMemId(memId);
			inputData.setMemPass(memPass);
			MemberVO authMember = service.authenticate(inputData);
//			인증된 사용자임을 증명하는 상태정보 생성 및 유지
			session.setAttribute("authMember", authMember);
			
//		- 성공 : 웰컴 페이지로 이동 - redirect
			return "redirect:/index.do";
		}catch (AuthenticateException e) {
//			- 실패 : 로그인 페이지로 이동 -forward	
			session.setAttribute("message", e.getMessage()); //flash
			return "redirect:/login/loginForm.jsp";
		}
		
			
		
	}
}
