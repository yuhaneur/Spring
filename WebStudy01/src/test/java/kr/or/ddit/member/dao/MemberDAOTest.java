package kr.or.ddit.member.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.vo.MemberVO;

class MemberDAOTest {

	MemberDAO dao = new MemberDAOImpl();
	
	@Test
	void testInsertMember() {
		MemberVO member = new MemberVO();
		assertThrows(PersistenceException.class, ()->dao.insertMember(member));
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemZip("00000");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		member.setMemBir("2024-01-01");
		int rowcnt = dao.insertMember(member);
		assertEquals(1, rowcnt);
	}

	@Test
	void testSelectMemberList() {
		List<MemberVO> memList = dao.selectMemberList();
		assertNotNull(memList);
		assertNotEquals(0, memList.size());
		System.out.println(memList);
	}

	@Test
	void testSelectMember() {
		String memId = "a001";
		MemberVO member = dao.selectMember(memId);
		assertNotNull(member);
		System.out.println(member);
		memId = "asdfasdf' OR '1'='1";
		assertNull(dao.selectMember(memId));
	}
	
	@Test
	void testUpdateMember() {
		MemberVO member = new MemberVO();
		member.setMemId("a002");
		member.setMemPass("java");
		member.setMemName("테스터");
		member.setMemAdd1("대전 오류");
		member.setMemAdd2("대덕인재개발원");
		member.setMemMail("aa@naver.com");
		int rowcnt = dao.update(member);
		assertEquals(1, rowcnt);
	}
	@Test
	void testDeleteMember() {
		String memId = "a001";
		int cnt = dao.delete(memId);
		assertEquals(0, cnt);
	}

}
