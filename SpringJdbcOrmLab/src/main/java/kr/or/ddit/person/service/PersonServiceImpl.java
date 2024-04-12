package kr.or.ddit.person.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.person.dao.PersonDAO;
import kr.or.ddit.person.exception.PersonNotFoundException;
import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{
	private final PersonDAO dao;
	@Override
	public List<PersonVO> retrievePersonList() {
		List<PersonVO> people = dao.selectPersonList();
		System.out.println("DAOpeople"+people);
		for(PersonVO once : people) {
			System.out.printf("%s 조회함.\n", once.getName());
		}
		return people;
	}

	@Override
	public PersonVO retrievePerson(String id) {
		PersonVO person= dao.selectPerson(id);
		if(person==null)
			throw new PersonNotFoundException(id);
		return person;
	}
	
}
