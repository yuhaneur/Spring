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

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.MemberVO;


/**
 * 1. 요청 접수, 분석
 * 2. 검증
 * 3. 로직 사용(model 확보)
 * 4. scope를 이용해 model 공유
 * 5. view 결정
 * 6. view로 이동(flow control)
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertControllerServlet extends HttpServlet{
	
	private MemberService service = new MemberServiceImpl();//의존관계
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName="/WEB-INF/views/member/memberForm.jsp";
		req.getRequestDispatcher(viewName).forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	 * 1. 요청 접수, 분석
		MemberVO member = new MemberVO(); // command Object (이 표현 잘기억해두기)
		req.setAttribute("member", member);
		Map<String, String[]> parameterMap = req.getParameterMap();
		PopulateUtils.populate(member, parameterMap);
		
		System.out.println(member);
//	 * 2. 검증
		Map<String, List<String>> errors = new LinkedHashMap<>();//현재는 errors가 비어있지만
		req.setAttribute("errors", errors);
		boolean valid = ValidateUtils.validate(member, errors,InsertGroup.class); //여기서는 errors에 담기게된다!@~!! return타입이 표현못하는걸 errors가 표현해줌 => call by reference 타입
		String viewName = null;
		if(errors.isEmpty()) {
//	 * 3. 로직 사용(model 확보)
			ServiceResult result = service.createMember(member);//커멘드 오브젝트?
			switch (result) {
			case PKDUPLICATED:
				req.setAttribute("message", "아이디 중복! 새로운 아이디를 입력하세요");
				viewName="member/memberForm";
				break;
			case FAIL:
				req.setAttribute("message", "서버 오류! 잠시 뒤 다시 가입하세요");
				viewName="member/memberForm";
				break;
			default: //성공했으면 커멘드 오브젝트는 필요가 없어짐. request를 없애고 가기. PRG패턴이 필요함
//				req.getSession().setAttribute("lastCreated",member);
//				viewName= "redirect:/member/memberList.do"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				viewName= "redirect:/"; //서블릿으로 가야하는 이유 : 한명 추가된 이후 다시 조회해야되니까!!
				break;
			}
//	 * 4. scope를 이용해 model 공유
			
		}else {
			viewName="member/memberForm";
		}
//	 * 5. view 결정
//	 * 6. view로 이동(flow control)
		new ViewResolverComposite().resolveView(viewName, req, resp);
	}

	
}
