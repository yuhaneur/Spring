package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.case04.service.DummyService;
import kr.or.ddit.case04.vo.DummyVO;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mission/case04")
@RequiredArgsConstructor
public class Case04MissionController {
	private final DummyService service ;
	@RequestMapping("mission")
	public ModelAndView handler1() {
		ModelAndView mav = new ModelAndView();
		DummyVO dummy=  service.retrieveInfo();
		mav.addObject("dummy",dummy);
		mav.setViewName("case04/mission");
		return mav;
	}
}
