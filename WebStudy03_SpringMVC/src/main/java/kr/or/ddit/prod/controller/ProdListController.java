package kr.or.ddit.prod.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.paging.SimpleCondition;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;


@Controller
public class ProdListController{
	@Autowired
	private ProdService service;
	
	@RequestMapping("/prod/prodList.do")
	public String prodList(Model model,@RequestParam(required = false , defaultValue = "1") int currentPage
			,@ModelAttribute("condition") SimpleCondition simpleCondition
			) {
		PaginationInfo paging = new PaginationInfo(3,2);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		List<ProdVO> prodList = service.retrieveProdList(paging);
		model.addAttribute("prodList", prodList);
		PaginationRenderer render = new DefaultPaginationRenderer();
		model.addAttribute("pagingHTML", render.renderPagination(paging, "paging"));
		return "prod/prodList";
	}
}
