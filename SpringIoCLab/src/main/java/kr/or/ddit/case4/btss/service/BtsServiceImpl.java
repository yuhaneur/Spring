package kr.or.ddit.case4.btss.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.case4.btss.dao.BtsDAO;
import kr.or.ddit.case4.btss.dao.InMemoryBtsDAOImpl;
import kr.or.ddit.case5.person.exception.PkNotFoundException;
import kr.or.ddit.vo.BtsVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 파이널로 생성된 프로퍼티만 생성자
@Service
public class BtsServiceImpl implements BtsService {
	private final BtsDAO dao;
	
	@Override
	public BtsVO readBts(String code) throws PkNotFoundException {
		BtsVO bts = dao.selectBts(code);
		if(bts==null) {
			throw new PkNotFoundException(404);
		}
		dao.incrementHit(code);
		return bts;
	}

	@Override
	public List<BtsVO> readBtsList() {
		return dao.selectBtsList();
	}

}
