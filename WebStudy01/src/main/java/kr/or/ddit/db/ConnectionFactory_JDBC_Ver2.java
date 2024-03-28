package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Factory Object[Method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조.
 *
 */
public class ConnectionFactory_JDBC_Ver2 {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	
	static {
		try(
			InputStream is = ConnectionFactory_JDBC_Ver2.class.getResourceAsStream("./Dbinfo.properties");
		) {
			Properties props= new Properties();
			props.load(is);
			OracleDataSource ods = new OracleDataSource();
			dataSource = ods;
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			ods.setURL(url);
			ods.setUser(user);
			ods.setPassword(password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} // constant pool 에 로딩됨.
	}
	public static Connection getConnection() throws SQLException {
		Connection conn =  dataSource.getConnection();
		
		return conn;
	}
}
