package kr.or.ddit.adrsdao;

import java.util.List;

import kr.or.ddit.adrsvo.AdrsVO;

public interface AdrsDao {
	/** 주소 등록
	 * @param adrs
	 * @return 등록된 컬럼수
	 */
	public int insertAdrs(AdrsVO adrs);
	/** 회원 주소리스트
	 * @return
	 */
	public List<AdrsVO> selectAdrsList();
	/** 회원 한명의 상세정보
	 * @param adrsId
	 * @return 없으면 null
	 */
	public AdrsVO selectAdrs(String adrsId);
	/** 주소 수정
	 * @param adrs
	 * @return
	 */
	public int update(AdrsVO adrs);
	/** 주소 삭제
	 * @param memId
	 * @return
	 */
	public int delete(String memId);
}
