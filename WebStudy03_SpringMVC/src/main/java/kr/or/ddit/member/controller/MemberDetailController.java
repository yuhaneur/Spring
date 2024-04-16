package kr.or.ddit.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

@Controller
public class MemberDetailController {
	@Autowired
	private MemberService service ;
	@GetMapping("/member/memberDetail.do")
	public String detail(Model model ,@RequestParam String who) {
		
		MemberVO member = service.retrieveMember(who); //모델 받아옴
		//scope
		model.addAttribute("member", member);
		//view
		return  "/jsonView.do";
		//flow control
		
	}
}
