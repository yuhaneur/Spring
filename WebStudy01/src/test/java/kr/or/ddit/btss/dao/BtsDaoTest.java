package kr.or.ddit.btss.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.hr.vo.BtsVO;

class BtsDaoTest {
	BtsDAO dao = new InMemoryBtsDAOImpl();
	@Test
	void test1() {
		assertNotNull(dao.selectBtsList());
	}
	
	@Test
	void test2() {
		assertNotNull(dao.selectBts("B001"));
//		assertNull(dao.selectBts("B021"));
	}
	@Test
	void test3() {
		dao.incrementHit("B001");
		BtsVO vo = dao.selectBts("B001");
		System.out.println(vo.getCount());
	}

}
