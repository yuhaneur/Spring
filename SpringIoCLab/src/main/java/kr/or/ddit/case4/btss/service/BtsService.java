package kr.or.ddit.case4.btss.service;

import java.util.List;

import kr.or.ddit.case5.person.exception.PkNotFoundException;
import kr.or.ddit.vo.BtsVO;

/**
 * Business Logic Layer
 *
 */
public interface BtsService {
	/**
	 * @param code
	 * @return 존재하지 않는 경우 ,{@link PkNotFoundException} 발생
	 */
	public BtsVO readBts(String code) throws PkNotFoundException;
	/**
	 * 전체 조회
	 * @return
	 */
	public List<BtsVO> readBtsList();
}
