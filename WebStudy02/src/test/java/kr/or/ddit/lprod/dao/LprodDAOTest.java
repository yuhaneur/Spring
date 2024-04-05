package kr.or.ddit.lprod.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import kr.or.ddit.vo.LprodVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class LprodDAOTest {
	private LprodDAO dao = new LprodDAOImpl();

	@Test
	void testSelectLprodList() {
		List<LprodVO> lprodList =  dao.selectLprodList();
		assertNotEquals(0, lprodList.size());
		lprodList.forEach(l->log.info("lprod : {}", l));
//		log.info("lprodList : {}", lprodList);
		
		List<BuyerVO> buyerList = new ArrayList<BuyerVO>();
		for(LprodVO lprod : lprodList) {
			buyerList.addAll(lprod.getBuyerList());
		}
		buyerList.forEach(b->log.info("buyer : {} ", b));
	}

}
