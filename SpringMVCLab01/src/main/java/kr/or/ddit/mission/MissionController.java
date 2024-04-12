package kr.or.ddit.mission;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mission/case01")
public class MissionController {
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
	public void handler() {
		log.info("json 응답만 받는 get 핸들러");
	}
	@PostMapping
	public void handler2() {
		log.info("post 핸들러");
	}
}
