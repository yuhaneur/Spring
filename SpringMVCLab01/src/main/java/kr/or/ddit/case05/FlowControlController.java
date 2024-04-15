package kr.or.ddit.case05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 일반적으로 controller 에서 사용하는 이동 방식
 * forward : controller --> view로 이동하는 경우.(logical view name 으로 이동)
 * 		controller --> controller 로 이동하는 경우. 
 * redirect
 *
 */
@Slf4j
@Controller
@RequestMapping("/case05")
public class FlowControlController {
	@RequestMapping("start3")
	public String handler5(RedirectAttributes redirectAttributes) {
		log.info("start2 번 요청 접수");
		redirectAttributes.addFlashAttribute("info","start3에서 만든 모델");
		redirectAttributes.addFlashAttribute("info1","start3에서 만든 모델1");
		redirectAttributes.addFlashAttribute("info2","start3에서 만든 모델2");
		return "redirect:/case05/dest3";
	}
	@RequestMapping("dest3")
	public void handler6(Model model ) {
		log.info("dest3번 요청 접수");
		model.asMap().forEach((k,v)->log.info("{} : {} ", k,v));
	}
	
	@RequestMapping("start2")
	public String handler3(RedirectAttributes redirectAttributes) {
		log.info("start2 번 요청 접수");
		redirectAttributes.addFlashAttribute("info","start2에서 만든 모델");
		return "redirect:/case05/dest2";
	}
	@RequestMapping("dest2")
	public void handler4(Model model ) {
		log.info("dest2번 요청 접수 , model : {}", model.getAttribute("info"));
	}
	
	
	@RequestMapping("start1")
	public String handler1(Model model) {
		log.info("start1 번 요청 접수");
		model.addAttribute("info","start1에서 만든 모델");
		return "forward:/case05/dest1";
	}
	@RequestMapping("dest1")
	public void handler2(@RequestAttribute(required = false) String info) {
		log.info("dest1 번 요청 접수,model : {}",info);
	}
}
