package kr.or.ddit.alba.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.AlbaModel;

@Mapper
public interface AlbaDAO {
	public List<AlbaModel> selectAlbaList();
	public AlbaModel selectAlba();
	public int insertAlba(AlbaModel alba);
	public int updateAlba(AlbaModel alba);
	public int deleteAlba(String alId);
}
