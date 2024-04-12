package kr.or.ddit.adrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AdrsVO;

@Mapper
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
	public AdrsVO selectAdrs(int adrsNo);
}
