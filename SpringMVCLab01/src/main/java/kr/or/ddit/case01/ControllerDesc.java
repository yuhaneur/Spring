package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * 스프링으로 컨트롤러를 구현하는 방법
 * 1. POJO 로 컨트롤러 구현.
 * 2. @Controller 로 컨테이너에 빈 등록.
 * 3. 각 커맨드 핸들러를 메소드로 구현.
 * 4. @RequestMapping 계열의 어노테이션으로 요청 매핑 조건 설정.
 * 		- url , method , accept, content-type , parameter ,path variable  
 *
 */
@Slf4j
@Controller
@RequestMapping("/case01/mapping1")
public class ControllerDesc {
	
	@RequestMapping("request1") // 요청을 받아주는 핸들러다.
	public void handler1() {
		log.info("handler1 번 동작");
	}
	@RequestMapping("request2") // 요청을 받아주는 핸들러다.
	public void handler2() {
		log.info("handler2 번 동작");
	}
	@RequestMapping("request3") // 요청을 받아주는 핸들러다.
	public void handler3() {
		log.info("handler3 번 동작");
	}
}
