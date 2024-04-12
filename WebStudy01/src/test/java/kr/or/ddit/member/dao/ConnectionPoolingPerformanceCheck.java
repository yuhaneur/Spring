package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.db.ConnectionFactory_HikariCP;
import kr.or.ddit.db.ConnectionFactory_JDBC_Ver2;
import kr.or.ddit.db.ConnectionFactory_JDBC_Ver3;
import kr.or.ddit.exception.PersistenceException;
import kr.or.ddit.hr.vo.MemberVO;

class ConnectionPoolingPerformanceCheck {
	static MemberDAO dao;
	
	@BeforeAll // 테스트 하기전에 준비하는메소드
	static void setUpBeforeClass() throws Exception {
		System.out.println("beforeClass");
		dao = new MemberDAOImpl();
	}
//	@BeforeEach // 테스트케이스 실행전 한번씩 실행 (데이터 이어서 사용해야되는데 초기화 할떄 )
//	void setUp() {
//		System.out.println("before each");
//	}
	@Test //Connection pooling 사용 이전의 소요시간 : 1.134s  ,0.34s
	//Connection pooling 사용 이후의 소요시간 : 0.377s  ,0.34s
	void testSelectMemberNonCP() {
//		System.out.println("test case1");
		for(int i =1; i<=1000;i++) {
			MemberVO member = null;
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT													  ");
			sql.append(" MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2,      ");
			sql.append(" TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR, MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL,   	  ");
			sql.append(" MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE,   	  ");
			sql.append(" MEM_MEMORIAL, TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY, MEM_MILEAGE, MEM_DELETE   ");
			sql.append(" FROM MEMBER  											  ");
			sql.append(" WHERE MEM_ID = ? 								  		  ");
			try(
				Connection conn = ConnectionFactory_JDBC_Ver2.getConnection();
//				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
//				3
				pstmt.setString(1, "a001");
				ResultSet rs = pstmt.executeQuery();
//				5
				 
				if(rs.next()) {
					member = new MemberVO();
					member.setMemId(rs.getString("MEM_ID"));
					member.setMemPass(rs.getString("MEM_PASS"));
					member.setMemName(rs.getString("MEM_NAME"));
					member.setMemRegno1(rs.getString("MEM_REGNO1"));
					member.setMemRegno2(rs.getString("MEM_REGNO2"));
					member.setMemBir(rs.getString("MEM_BIR"));
					member.setMemZip(rs.getString("MEM_ZIP"));
					member.setMemAdd1(rs.getString("MEM_ADD1"));
					member.setMemAdd2(rs.getString("MEM_ADD2"));
					member.setMemHometel(rs.getString("MEM_HOMETEL"));
					member.setMemComtel(rs.getString("MEM_COMTEL"));
					member.setMemHp(rs.getString("MEM_HP"));
					member.setMemMail(rs.getString("MEM_MAIL"));
					member.setMemJob(rs.getString("MEM_JOB"));
					member.setMemLike(rs.getString("MEM_LIKE"));
					member.setMemMemorial(rs.getString("MEM_MEMORIAL"));
					member.setMemMemorialday(rs.getString("MEM_MEMORIALDAY"));
					member.setMemMileage(rs.getLong("MEM_MILEAGE"));
					member.setMemDelete(rs.getString("MEM_DELETE"));
				}
				rs.close();
			}catch(SQLException e) {
				throw new PersistenceException(e);
			}
			System.out.printf("%s, %d번째\n",member.getMemName(),i);
		}
	}
	
	@Test 
	void testSelectMemberCP() {
//		System.out.println("test case1");
		for(int i =1; i<=1000;i++) {
			MemberVO member = null;
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT													  ");
			sql.append(" MEM_ID, MEM_PASS, MEM_NAME, MEM_REGNO1, MEM_REGNO2,      ");
			sql.append(" TO_CHAR(MEM_BIR, 'YYYY-MM-DD') MEM_BIR, MEM_ZIP, MEM_ADD1, MEM_ADD2, MEM_HOMETEL,   	  ");
			sql.append(" MEM_COMTEL, MEM_HP, MEM_MAIL, MEM_JOB, MEM_LIKE,   	  ");
			sql.append(" MEM_MEMORIAL, TO_CHAR(MEM_MEMORIALDAY, 'YYYY-MM-DD') MEM_MEMORIALDAY, MEM_MILEAGE, MEM_DELETE   ");
			sql.append(" FROM MEMBER  											  ");
			sql.append(" WHERE MEM_ID = ? 								  		  ");
			try(
					Connection conn = ConnectionFactory_HikariCP.getConnection();
//				Statement stmt = conn.createStatement();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					){
//				3
				pstmt.setString(1, "a001");
				ResultSet rs = pstmt.executeQuery();
//				5
				
				if(rs.next()) {
					member = new MemberVO();
					member.setMemId(rs.getString("MEM_ID"));
					member.setMemPass(rs.getString("MEM_PASS"));
					member.setMemName(rs.getString("MEM_NAME"));
					member.setMemRegno1(rs.getString("MEM_REGNO1"));
					member.setMemRegno2(rs.getString("MEM_REGNO2"));
					member.setMemBir(rs.getString("MEM_BIR"));
					member.setMemZip(rs.getString("MEM_ZIP"));
					member.setMemAdd1(rs.getString("MEM_ADD1"));
					member.setMemAdd2(rs.getString("MEM_ADD2"));
					member.setMemHometel(rs.getString("MEM_HOMETEL"));
					member.setMemComtel(rs.getString("MEM_COMTEL"));
					member.setMemHp(rs.getString("MEM_HP"));
					member.setMemMail(rs.getString("MEM_MAIL"));
					member.setMemJob(rs.getString("MEM_JOB"));
					member.setMemLike(rs.getString("MEM_LIKE"));
					member.setMemMemorial(rs.getString("MEM_MEMORIAL"));
					member.setMemMemorialday(rs.getString("MEM_MEMORIALDAY"));
					member.setMemMileage(rs.getLong("MEM_MILEAGE"));
					member.setMemDelete(rs.getString("MEM_DELETE"));
				}
				rs.close();
			}catch(SQLException e) {
				throw new PersistenceException(e);
			}
			System.out.printf("%s, %d번째\n",member.getMemName(),i);
		}
	}
	
	
	@Test
	void testDummy() {
		System.out.println("test case2");
	}

}
