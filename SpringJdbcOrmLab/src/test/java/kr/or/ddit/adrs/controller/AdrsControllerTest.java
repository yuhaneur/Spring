package kr.or.ddit.adrs.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.AbstractModelContextTest;
import kr.or.ddit.vo.AdrsVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional // AOP 방법에 따른 트랜잭션 관리
class AdrsControllerTest extends AbstractModelContextTest{
	@Autowired
	AdrsController controller;
	@Test
	void testAdrsListToResponse() {
		controller.adrsListToResponse();
	}

//	@Test
//	void testAdrsResponse(int adrsNo) {
//		adrsNo=1;
//		log.info("멤버한명 : {}",controller.adrsResponse(adrsNo));
//	}

	@Test
	void testAdrsInsert() {
		AdrsVO vo = new AdrsVO();
		vo.setAdrsAdd("test2");
		vo.setAdrsName("test2");
		vo.setAdrsTel("test2");
		vo.setMemId("a001");
		String result = controller.adrsInsert(vo);
		log.info("등록 결과 : {}",result);
	}

}
