package kr.or.ddit.alba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.paging.PaginationInfo;
import kr.or.ddit.vo.AlbaModel;

@Mapper
public interface AlbaDAO {
	public int selectTotalRecord(PaginationInfo paging);
	public List<AlbaModel> selectAlbaList(PaginationInfo paging);
	public AlbaModel selectAlba(String alId);
	public int insertAlba(AlbaModel alba);
	public int updateAlba(AlbaModel alba);
	public int deleteAlba(String alId);
}
