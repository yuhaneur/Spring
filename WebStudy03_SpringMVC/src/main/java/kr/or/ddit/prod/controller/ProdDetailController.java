package kr.or.ddit.prod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;

@Controller
public class ProdDetailController{
	@Autowired
	private ProdService service ;
	
	@RequestMapping("/prod/prodDetail.do")
	public String prodDetail(Model model, @RequestParam String what)  {
//		String prodId = (String) req.getParameter("what");
		ProdVO prod = service.retrieveProd(what);
		model.addAttribute("prod", prod);
		
		return "prod/prodDetail";
		
		
	}
}
