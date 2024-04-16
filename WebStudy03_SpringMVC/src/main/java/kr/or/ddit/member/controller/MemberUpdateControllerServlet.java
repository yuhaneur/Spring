package kr.or.ddit.member.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope를 이용해 model 공유
 * 5. view 결정
 * 6. view로 이동(flow control)
 */
@Controller
@RequestMapping("/member/memberUpdate.do")
public class MemberUpdateControllerServlet{
	@Autowired
	private MemberService service ;//의존관계
	
	@GetMapping
	public String doGet(Model model ,Principal principal)  {
		if(!model.containsAttribute("member")) {
			String memId = principal.getName();
			MemberVO member = service.retrieveMember(memId);
			model.addAttribute("member", member);
		}
		
		return "member/memberForm";
		

	}
	
	@PostMapping
	public String doPost(Model model,@Validated @ModelAttribute MemberVO member,Errors errors,RedirectAttributes redirectAttributes )  {
			String viewName = null;
			if(!errors.hasErrors()) {
				service.modifyMember(member);
//		 * 3. 로직 사용(model 확보)
				ServiceResult result = service.modifyMember(member);//커멘드 오브젝트?
				switch (result) {
				case INVALIDPASSWORD:
					redirectAttributes.addFlashAttribute("message", "비밀번호 불일치! 올바른 비밀번호를 입력하세요");
					viewName="redirect:/member/memberUpdate.do";
					break;
				case FAIL:
					model.addAttribute("message", "서버 오류! 잠시 뒤 다시 가입하세요");
					viewName="member/memberForm";
					break;
				default: //성공했으면 커멘드 오브젝트는 필요가 없어짐. request를 없애고 가기. PRG패턴이 필요함
//					req.getSession().setAttribute("lastCreated",member); //
//					viewName= "redirect:/member/memberList.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
					viewName= "redirect:/mypage"; 
					break;
				}
//		 * 4. scope를 이용해 model 공유
				
			}else {
				redirectAttributes.addFlashAttribute("member", member);
				redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"member", errors);
				viewName="redirect:/member/memberUpdate.do";
			}
//		 * 5. view 결정
//		 * 6. view로 이동(flow control)
			return viewName;
		}


}
