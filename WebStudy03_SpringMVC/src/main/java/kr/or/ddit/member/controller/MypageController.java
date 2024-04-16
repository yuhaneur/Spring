package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.MemberVOWrapper;

@Controller
public class MypageController {
	@Autowired
	private MemberService service ;
	
	@GetMapping("/mypage")
	public String doGet(Principal principal, Model model) {
		MemberVO member = service.retrieveMember(principal.getName());
		model.addAttribute("member", member);
		return "member/mypage";

	}
}
