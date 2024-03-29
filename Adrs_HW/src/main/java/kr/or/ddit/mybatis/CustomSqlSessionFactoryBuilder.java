package kr.or.ddit.mybatis;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomSqlSessionFactoryBuilder {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		
		String resource = "kr/or/ddit/mybatis/Configuration.xml";
		try(
				Reader reader =Resources.getResourceAsReader(resource);
		){
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			
		}catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
