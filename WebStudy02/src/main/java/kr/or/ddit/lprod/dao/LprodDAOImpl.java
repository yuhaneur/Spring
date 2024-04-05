package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.zaxxer.hikari.util.ClockSource.Factory;

import kr.or.ddit.mybatis.CustomSqlSessionFacotryBuilder;
import kr.or.ddit.vo.LprodVO;

public class LprodDAOImpl implements LprodDAO {

	private SqlSessionFactory Factory = CustomSqlSessionFacotryBuilder.getSqlSessionFactory();
	@Override
	public List<LprodVO> selectLprodList() {
		try(
			SqlSession session = Factory.openSession();
		){
			return session.getMapper(LprodDAO.class).selectLprodList();
		}
	}
	
}
