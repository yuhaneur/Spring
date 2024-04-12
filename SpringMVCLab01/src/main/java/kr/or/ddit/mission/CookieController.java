package kr.or.ddit.mission;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/mission/case02")
public class CookieController {
	
	@GetMapping
	public void handler1(
		@RequestHeader(name = "user-agent", required = true) String userAgent
		,@CookieValue(required = false,defaultValue = "1000") int myCookie) {
		log.info("userAgent : {} , myCookie : {}",userAgent,myCookie);
	}
}
