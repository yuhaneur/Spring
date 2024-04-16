package kr.or.ddit.member.controller;

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
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ProdVO;


/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope를 이용해 model 공유
 * 5. view 결정
 * 6. view로 이동(flow control)
 */
@Controller
@RequestMapping("/member/memberInsert.do")
public class MemberInsertControllerServlet {
	public static final String MODELNAME="member";
	@Autowired
	private MemberService service ;//의존관계
	@GetMapping
	public String formHandler(Model model,@ModelAttribute(MODELNAME) MemberVO member)  {
		if(!model.containsAttribute(MODELNAME)) {
			model.addAttribute(MODELNAME, new MemberVO());
		}
		return "/member/memberForm";
	}
	
	@PostMapping
	public String insertMember(Model model
			,@Validated(InsertGroup.class) @ModelAttribute(MODELNAME) MemberVO member
			,Errors errors
			,RedirectAttributes redirectAttributes) {
		String viewName = null;
		if(errors.hasErrors()) {
//	 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createMember(member);//커멘드 오브젝트?
			switch (result) {
			case PKDUPLICATED:
				redirectAttributes.addFlashAttribute("member", member);
				redirectAttributes.addFlashAttribute("message", "아이디 중복! 새로운 아이디를 입력하세요");
				viewName="redirect:/member/memberInsert.do";
				break;
			case FAIL:
				model.addAttribute("message", "서버 오류! 잠시 뒤 다시 가입하세요");
				viewName="member/memberForm";
				break;
			default: //성공했으면 커멘드 오브젝트는 필요가 없어짐. request를 없애고 가기. PRG패턴이 필요함
//				req.getSession().setAttribute("lastCreated",member);
//				viewName= "redirect:/member/memberList.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				viewName= "redirect:/index.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				break;
			}
//	 * 4. scope를 이용해 model 공유
			
		}else {
			redirectAttributes.addFlashAttribute("member", member);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"member", errors);
			viewName="redirect:/member/memberInsert.do";
		}
		return viewName;
	}

	
}
