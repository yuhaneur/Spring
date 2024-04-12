package kr.or.ddit.person.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.person.controller.PersonController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class PersonDAOTest extends AbstractModelContextTest{
	
	@Resource(name = "personDAO")
	PersonDAO personDAO;
	@Autowired
	PersonController controller;
	@Test
	void testSelectPersonList() {
//		personDAO.selectPersonList();
		controller.personListToResponse().forEach(p->log.info("list : {}",p));
	}

	@Test
	void testSelectPerson() {
		personDAO.selectPerson("M0014");
	}

}
