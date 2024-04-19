package kr.or.ddit.mission;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.case09.CalculateVO;

@RestController
@RequestMapping("/mission/case08_9")
public class case8_9_MissionController {
	
	@PostMapping
	public CalculateVO handler(@RequestBody CalculateVO calVO) {
		return calVO;
	}
}
