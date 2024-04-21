package kr.or.ddit.alba.controller;

import java.util.List;

import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.alba.ServiceResult;
import kr.or.ddit.alba.service.AlbaService;
import kr.or.ddit.paging.DefaultPaginationRenderer;
import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.paging.PaginationRenderer;
import kr.or.ddit.vo.AlbaModel;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/alba")
@RequiredArgsConstructor
public class AlbaController {
	private final AlbaService service;
	@GetMapping
	public String albaList(Model model,@ModelAttribute("paging") PaginationInfo paging) {
		List<AlbaModel> albaList = service.retrieveAlbaList(paging);
		model.addAttribute("albaList", albaList);
		PaginationRenderer render = new DefaultPaginationRenderer();
		model.addAttribute("pagingFunction", "paging");
		String pagingHTML =  render.renderPagination(paging, "paging");
		model.addAttribute("pagingHTML", pagingHTML);
		return "alba/albaListForm";
	}
	
	@GetMapping("{who}")
	public String alba(Model model,@PathVariable String who) {
		AlbaModel alba = service.retrieveAlba(who);
		model.addAttribute("alba", alba);
		return "alba/albaDetailForm";
	}
	
	@GetMapping("insert")
	public String albaInsertForm(Model model) {
		if(!model.containsAttribute("alba")) {
			model.addAttribute("alba",new AlbaModel());
		}
		return "alba/albaInsertForm";
	}
	@PostMapping("insert")
	public String albaInsert(
			@Validated(Default.class) @ModelAttribute("alba") AlbaModel alba
			,Errors errors
			,RedirectAttributes redirectAttributes) {
		String viewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createtAlba(alba);
			switch (result) {
			case FAIL:
				viewName = "insert";
				break;
			default:
				viewName = "redirect:/alba"; 
				break;
			}
		}else {
			redirectAttributes.addFlashAttribute("alba", alba);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX+"alba", errors);
			viewName = "redirect:/alba/insert";
		}
		return viewName;
	}
	
}
