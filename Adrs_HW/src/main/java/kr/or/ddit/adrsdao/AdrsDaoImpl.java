package kr.or.ddit.adrsdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.adrsvo.AdrsVO;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;

public class AdrsDaoImpl implements AdrsDao {
	private SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	@Override
	public int insertAdrs(AdrsVO adrs) {
		try(
			SqlSession session = factory.openSession();
		){
			
		}
		return 0;
	}

	@Override
	public List<AdrsVO> selectAdrsList() {
		return null;
	}

	@Override
	public AdrsVO selectAdrs(String adrsId) {
		return null;
	}

	@Override
	public int update(AdrsVO adrs) {
		return 0;
	}

	@Override
	public int delete(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
