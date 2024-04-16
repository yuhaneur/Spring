package kr.or.ddit.prod.controller;

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
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodInsert.do")
public class ProdInsertController{
	public static final String MODELNAME = "newProd";
	
	@Autowired
	private ProdService service ;
	
	@GetMapping
	public String insertForm(Model model)  {
		model.addAttribute(MODELNAME, new ProdVO());
		return "prod/prodForm";
	}
	
	@PostMapping
	public String prodInsert(
			Model model 
			, @Validated(InsertGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
			, Errors errors)  {
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createProd(prod);
			switch (result) {
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 등록하세요");
				viewName = "prod/Form";
				break;
			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId(); 
				break;
			}
			
		}else {
			viewName = "prod/prodForm";
		}
		return viewName;
	}
}
