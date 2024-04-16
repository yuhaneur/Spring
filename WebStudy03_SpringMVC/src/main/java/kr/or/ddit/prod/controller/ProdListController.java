package kr.or.ddit.prod.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.vo.ProdVO;


@Controller
public class ProdListController{
	@Autowired
	private ProdService service;
	
	@RequestMapping("/prod/prodList.do")
	public String prodList(Model model) {
		List<ProdVO> prodList = service.retrieveProdList();
		model.addAttribute("prodList", prodList);
		return "prod/prodList";
	}
}
