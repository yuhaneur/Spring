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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.lprod.controller.OthersControllerAdvice;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.validate.groups.UpdateGroup;
import kr.or.ddit.vo.ProdVO;

@Controller
@RequestMapping("/prod/prodUpdate.do")
public class ProdUpdateController {
	
	public static final String MODELNAME = "prod";
	@Autowired
	private ProdService service ;


	@GetMapping
	public String updateForm(@RequestParam String what, Model model) {
	    ProdVO prod = service.retrieveProd(what);
	    model.addAttribute(MODELNAME, prod);
	    return  "prod/prodUpdate";

	}

   @PostMapping
   public String prodUpdate(Model model ,@Validated(UpdateGroup.class) @ModelAttribute(MODELNAME) ProdVO prod
		   , Errors errors)  {
	   boolean vaild = errors.hasErrors();
	   String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyProd(prod);
			switch (result) {
			case FAIL:
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 등록하세요");
				viewName = "prod/prodUpdate";
				break;
			default:
				viewName = "redirect:/prod/prodDetail.do?what="+prod.getProdId(); 
				break;
			}
			
		}else {
			viewName = "prod/prodUpdate";
		}
		return viewName;
	}
}
