package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.vo.LprodVO;

@Mapper
public interface LprodDAO {
	public List<LprodVO> selectLprodList();
}
