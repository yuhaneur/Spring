package kr.or.ddit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;


/**
 * C : /member/memberInsert.do(GET, POST)
 * R (GET)
 * 단건 : /member/memberDetail.do?who=a001
 * 다건 : /member/memberList.do
 * U : /member/memberUpdate.do (GET, POST)
 * D : /member/memberDelete.do (POST)
 * 
 */
@Slf4j
@Controller
public class MemberListController  {
//	private static final Logger logger = LoggerFactory.getLogger(MemberListControllerServlet.class); //굉장히 흔한 코드. (중복 가능성)
//	private static final Logger logger2 = LoggerFactory.getLogger("jdbc.resultsettable");
	@Autowired
	private MemberService service ;
	@GetMapping("/member/memberList.do")
	public String memberList(HttpServletRequest req, HttpServletResponse resp)  {
		log.info("컨트롤러 동작");
//		System.out.println("컨트롤러 동작");
		List<MemberVO> mlist = service.retrieveMemberList();
//		System.out.printf("%s\n", mlist);
		log.info("조회된 모델: {}", mlist); //{} : 메세지 argument
		//scope
		req.setAttribute("mlist",mlist);
		//view
		String accept = req.getHeader("accept");
		String viewName="";
		if(accept.contains("json")) { //list객체를 json으로 마샬링 하는 작업
			return "/jsonView.do";
		}else {
			return "member/memberList";
		}
		//flow control
	}

}
