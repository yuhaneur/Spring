package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
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
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.vo.MemberVO;

/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope를 이용해 model 공유
 * 5. view 결정
 * 6. view로 이동(flow control)
 */
@WebServlet("/member/memberUpdate.do")
public class MemberUpdateControllerServlet extends HttpServlet{
	private MemberService service = new MemberServiceImpl();//의존관계
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId = req.getUserPrincipal().getName();
		HttpSession session = req.getSession();
		String viewName = null;
		
		MemberVO member = service.retrieveMember(memId);
		req.setAttribute("member", member);
		viewName = "member/memberForm";
		

		new ViewResolverComposite().resolveView(viewName, req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 * 1. 요청 접수, 분석
			resp.setCharacterEncoding("UTF-8");
			MemberVO member = new MemberVO(); // command Object (이 표현 잘기억해두기)
			req.setAttribute("member", member);
			Map<String, String[]> parameterMap = req.getParameterMap();
			try {
				BeanUtils.populate(member, parameterMap);
			} catch (IllegalAccessException | InvocationTargetException e) {
				throw new RuntimeException(e);
			} 
			
			System.out.println(member);
//		 * 2. 검증
			Map<String, List<String>> errors = new LinkedHashMap<>();//현재는 errors가 비어있지만
			req.setAttribute("errors", errors);
			boolean valid = ValidateUtils.validate(member, errors); //여기서는 errors에 담기게된다!@~!! return타입이 표현못하는걸 errors가 표현해줌 => call by reference 타입
			String viewName = null;
			if(errors.isEmpty()) {
				service.modifyMember(member);
//		 * 3. 로직 사용(model 확보)
				ServiceResult result = service.modifyMember(member);//커멘드 오브젝트?
				switch (result) {
				case INVALIDPASSWORD:
					req.setAttribute("message", "비밀번호 불일치! 올바른 비밀번호를 입력하세요");
					viewName="/WEB-INF/views/member/memberForm.jsp";
					break;
				case FAIL:
					req.setAttribute("message", "서버 오류! 잠시 뒤 다시 가입하세요");
					viewName="/WEB-INF/views/member/memberForm.jsp";
					break;
				default: //성공했으면 커멘드 오브젝트는 필요가 없어짐. request를 없애고 가기. PRG패턴이 필요함
//					req.getSession().setAttribute("lastCreated",member); //
//					viewName= "redirect:/member/memberList.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
					viewName= "redirect:/mypage"; 
					break;
				}
//		 * 4. scope를 이용해 model 공유
				
			}else {
				viewName="/WEB-INF/views/member/memberForm.jsp";
			}
//		 * 5. view 결정
//		 * 6. view로 이동(flow control)
			new ViewResolverComposite().resolveView(viewName, req, resp);
		}


}
