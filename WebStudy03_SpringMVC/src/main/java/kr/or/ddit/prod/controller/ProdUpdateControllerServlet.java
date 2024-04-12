package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@WebServlet("/prod/prodUpdate.do")
public class ProdUpdateControllerServlet extends HttpServlet{
	
	 private ProdService service = new ProdServiceImpl();
	 private OthersControllerAdvice advice = new OthersControllerAdvice();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String prodId = req.getParameter("what");
      if(StringUtils.isBlank(prodId)) {
    	  resp.sendError(400);
    	  return;
      }
      ProdVO prod = service.retrieveProd(prodId);
      req.setAttribute("prod", prod);
      String viewName = "prod/prodUpdate";
      new ViewResolverComposite().resolveView(viewName, req, resp);

	}

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		1. 요청 접수, 분석
		req.setCharacterEncoding("UTF-8");
		ProdVO prod = new ProdVO(); // command Object (이 표현 잘기억해두기)
		req.setAttribute("prod", prod);
		Map<String, String[]> parameterMap = req.getParameterMap();
		
		PopulateUtils.populate(prod, parameterMap);
//		 * 2. 검증
			Map<String, List<String>> errors = new LinkedHashMap<>();//현재는 errors가 비어있지만
			req.setAttribute("errors", errors);
			boolean valid = ValidateUtils.validate(prod, errors,UpdateGroup.class); //여기서는 errors에 담기게된다!@~!! return타입이 표현못하는걸 errors가 표현해줌 => call by reference 타입
			String viewName = null;
			if(errors.isEmpty()) {
//		 * 3. 로직 사용(model 확보)
				ServiceResult result = service.modifyProd(prod);//커멘드 오브젝트?
				switch (result) {
				case FAIL:
					req.setAttribute("message", "서버 오류! 잠시 뒤 다시 수정하세요");
					viewName="prod/prodUpdate";
					break;
				default: 
					viewName= "redirect:/prod/prodDetail.do?what="+prod.getProdId(); 
					break;
				}
//		 * 4. scope를 이용해 model 공유
				
			}else {
				viewName="prod/prodList";
			}
//		 * 5. view 결정
//		 * 6. view로 이동(flow control)
			new ViewResolverComposite().resolveView(viewName, req, resp);
		
		}
}
