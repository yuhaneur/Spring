package kr.or.ddit.servlet10.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory_JDBC_Ver1;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.utils.NamingUtils;

public class PropertyDAOImpl implements PropertyDAO{

	@Override
	public List<Map<String, Object>> selectProperties(Map<String, Object> paramMap) {
		try(
				Connection conn = ConnectionFactory_JDBC_Ver1.getConnection();
				Statement stmt =  conn.createStatement();
			){
				StringBuffer sql = new StringBuffer();
				sql.append(" SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION ");
				sql.append(" FROM DATABASE_PROPERTIES");
				ResultSet rs = stmt.executeQuery(sql.toString());
				
				List<Map<String,Object>> proList = new ArrayList();
				ResultSetMetaData metaData =  rs.getMetaData();
				int count = metaData.getColumnCount();
				String[] headers = new String[count];
				String[] propsName = new String[count];
				
				paramMap.put("proList", proList);
				paramMap.put("headers", headers);
				paramMap.put("propsName", propsName);
				
				for(int idx=1;idx<=count;idx++){
					headers[idx-1] = metaData.getColumnName(idx);
					propsName[idx-1] = NamingUtils.snakeToCamel(headers[idx-1]);
				}
				while(rs.next()){
					Map<String,Object> proMap = new HashMap();
					for(String columName : headers){
						proMap.put(NamingUtils.snakeToCamel(columName),rs.getString(columName));
					}
					proList.add(proMap);
				}
				rs.close();
				return proList;
			}catch(SQLException e) {
				throw new PersistenceException(e);
			}
	}

}
