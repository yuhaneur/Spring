package kr.or.ddit.case01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/case01/mapping2")
public class HttpMethodMappingController {
	
	@RequestMapping(method = {RequestMethod.HEAD,RequestMethod.PATCH}) // 밑에 구체적인 메소드 말고 나머지 요청은 여기서받겠다.
	public void handlerOthers() {
		log.info("other method handler 동작");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public void handler1Get() {
		log.info("get handler 동작");
	}
	@PostMapping
	public void handler2Post() {
		log.info("post handler 동작");
	}
	@PutMapping
	public void handler2Put() {
		log.info("put handler 동작");
	}
	@DeleteMapping
	public void handler2Delete() {
		log.info("Delete handler 동작");
	}
}
