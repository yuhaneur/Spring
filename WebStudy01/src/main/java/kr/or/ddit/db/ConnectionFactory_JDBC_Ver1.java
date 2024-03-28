package kr.or.ddit.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Factory Object[Method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도 운영하는 구조.
 *
 */
public class ConnectionFactory_JDBC_Ver1 {
	private static String url;
	private static String user;
	private static String password;
	
	static {
		try(
			InputStream is = ConnectionFactory_JDBC_Ver1.class.getResourceAsStream("./Dbinfo.properties");
		) {
			Properties props= new Properties();
			props.load(is);
			
			Class.forName(props.getProperty("driverClassName"));
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} // constant pool 에 로딩됨.
	}
	public static Connection getConnection() throws SQLException {
		Connection conn =  DriverManager.getConnection(url, user, password);
		
		return conn;
	}
}
