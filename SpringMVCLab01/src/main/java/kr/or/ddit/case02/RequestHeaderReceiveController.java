package kr.or.ddit.case02;

import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/case02")
public class RequestHeaderReceiveController {
	
	
	@RequestMapping("header6")
	public void handler6(@RequestHeader Optional<String> optHeader ) {
		log.info("optHeader : {}", optHeader.orElse("default value"));
	}
	
	@RequestMapping("header5")
	public void handler5(@RequestHeader(name = "myHeader",required = false, defaultValue = "1000") long myHeader) {
		log.info("myHeader : {} ", myHeader);
	}
	@RequestMapping("header4")
	public void handler4(@RequestHeader(name = "Accept",required = true) String accept) {
		log.info("accept : {} ", accept);
	}
	
	@RequestMapping("header3")
	public void handler3(@RequestHeader MultiValueMap<String, String> headers) {
		headers.forEach((k,v)->log.info("{} : {}",k,v));
	}
	
	@RequestMapping("header2")
	public void handler2(@RequestHeader Map<String, Object> headers) {
		headers.forEach((k,v)->log.info("{} : {}",k,v));
	}
	
	@RequestMapping("header1")
	public void handler1(HttpServletRequest req) {
		Enumeration<String> names = req.getHeaderNames();
		while (names.hasMoreElements()) {
			String headerName = (String) names.nextElement();
			String headerValue = req.getHeader(headerName);
			log.info("{} : {} ", headerName, headerValue);
		}
	}
}
