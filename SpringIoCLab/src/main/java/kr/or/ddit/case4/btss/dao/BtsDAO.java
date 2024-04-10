package kr.or.ddit.case4.btss.dao;

import java.util.List;

import kr.or.ddit.vo.BtsVO;

/**
 * Persistence Layer
 *
 */
public interface BtsDAO {
	/**
	 * @param code
	 * @return 없으면 null 반환
	 */
	public BtsVO selectBts(String code);
	/**
	 * BTS 멤버 전체 조회
	 * @return
	 */
	public List<BtsVO> selectBtsList();
	
	/**
	 * 한사람의 멤버가 조회될때 조회수를 증가시킴.
	 * @param code
	 */
	public void incrementHit(String code);
}
