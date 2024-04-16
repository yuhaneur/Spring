package kr.or.ddit.mission;

import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/mission/case06")
public class Case06MissionController {

	@GetMapping
	public String handler2() {
		return "case06/missionForm";
	}
	
	@PostMapping
	public String handler1(RedirectAttributes redirectAttributes,Optional<Integer> leftOp,Optional<Integer> rightOp) {
		int num1=leftOp.orElse(0);
		int num2=rightOp.orElse(0);
		int result = num1+num2;
//		model.addAttribute("result", result);
		redirectAttributes.addFlashAttribute("leftOp", num1);
		redirectAttributes.addFlashAttribute("rightOp", num2);
		redirectAttributes.addFlashAttribute("result", result);
		return "redirect:/mission/case06";
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void process2(Model model,Optional<Integer> leftOp,Optional<Integer> rightOp) {
		int num1=leftOp.orElse(0);
		int num2=rightOp.orElse(0);
		int result = num1+num2;
//		model.addAttribute("result", result);
		model.addAttribute("leftOp", num1);
		model.addAttribute("rightOp", num2);
		model.addAttribute("result", result);
	}
}
