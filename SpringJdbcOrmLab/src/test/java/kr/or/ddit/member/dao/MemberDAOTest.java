package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "classpath:kr/or/ddit/case2/conf/*-context.xml")
class MemberDAOTest {
	@Autowired
	MemberDAO dao;
	@Test
	void testSelectMemberList() {
		dao.selectMemberList();
	}

	@Test
	void testSelectMember() {
		dao.selectMember("a001");
	}

}
