package kr.or.ddit.person.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.person.service.PersonService;
import kr.or.ddit.vo.PersonVO;


/**
 * RESTful URI
 * (명사 - URI 와 동사-method의 분리형태)
 * 
 * /member/memberList.do 회원목록
 * /member/memberInsert.do 회원등록
 * 
 * /member (GET) 회원의 목록을 조회하다.
 * /member/a001 (GET) a001을 조회하다.
 * /member/a001 (PUT) a001을 수정하다.
 * /member/a001 (DELETE) a001을 삭제하다.
 * /member/new (POST) 새로운 회원을 등록하다.
 */
@Controller
@RequestMapping("/people")
public class PersonRetrieveController {
//	private PersonDAOImpl dao = new PersonDAOImpl();
	@Autowired
	private PersonService service ;
	
	@GetMapping
	public String personList(Model model) {
		List<PersonVO> people = service.retrievePersonList();
		model.addAttribute("people",people);
		return "person/people_el";
	}
	@GetMapping("{who}")
	public String service(Model model, @PathVariable String who) {
		PersonVO person = service.retrievePerson(who);
		model.addAttribute("person", person);
		return "person/detail";
	}

}
