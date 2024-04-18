package kr.or.ddit.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.paging.SimpleCondition;
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
	@RequestMapping("/member/memberList.do")
	   public String ListProcess(Model model
			 ,@ModelAttribute("paging") PaginationInfo paging
//			 ,SimpleCondition simpleCondition
	         ) {
//	      paging.setSimpleCondition(simpleCondition);
	      List<MemberVO> mlist = service.retrieveMemberList(paging);
	      // scope
	      model.addAttribute("mlist", mlist);
	      PaginationRenderer render = new DefaultPaginationRenderer();
	      model.addAttribute("pagingFunction", "paging");
	      String pagingHTML =  render.renderPagination(paging, "paging");
	      model.addAttribute("pagingHTML", pagingHTML);
	      // view
	      return "member/memberList";
	   } 


}
