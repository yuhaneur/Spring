package kr.or.ddit.member.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.AbstractRootContextTest;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.MemberVO;

//@ContextConfiguration("file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class MemberServiceTest extends AbstractRootContextTest{
	
	@Autowired
	MemberService service ;

	@Test
	void testCreateMember() {
		fail("Not yet implemented");
	}

	@Test
	void testRetrieveMemberList() {
		service.retrieveMemberList();
	}

	@Test
	void testRetrieveMember() {
		fail("Not yet implemented");
	}

	@Test
	void testModifyMember() {
		final MemberVO member = new MemberVO();
		member.setMemId("asdfasdf");
		assertThrows(PkNotFoundException.class, ()-> service.modifyMember(member));
		member.setMemId("a001");
		member.setMemPass("asdfasdf");
		assertEquals(ServiceResult.INVALIDPASSWORD, service.modifyMember(member));
		MemberVO memberOk = service.retrieveMember(member.getMemId());
		assertEquals(ServiceResult.OK, service.modifyMember(memberOk));
	}

	@Test
	void testRemoveMember() {
		final MemberVO member = new MemberVO();
		member.setMemId("asdfasdf");
		assertThrows(PkNotFoundException.class, ()-> service.removeMember(member));
		member.setMemId("a001");
		member.setMemPass("adfasdf");
		assertEquals(ServiceResult.INVALIDPASSWORD, service.removeMember(member));
		member.setMemPass("asdfasdf");
		assertEquals(ServiceResult.OK, service.removeMember(member));
		
	}


}
