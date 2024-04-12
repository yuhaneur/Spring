package kr.or.ddit.case5.person.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.PersonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Repository
public class PersonDAOImpl implements PersonDAO {
//	private  Resource cpRes;
	@javax.annotation.Resource(name = "props")
	private Properties props;
	@Value("file:D:/00.medias/another_day.txt")
	private Resource fsRes;
	public void setFsRes(Resource fsRes) {
		this.fsRes = fsRes;
	}
//	@Value("classpath:kr/or/ddit/db/Dbinfo.properties")
//	private Resource dbinfo ;
//	@Value("#{props.user}")
//	private String user;
//	public void setUser(String user) {
//		this.user = user;
//	}
	@PostConstruct
	public void init() {
//		Properties pro = new Properties();
//		try {
//			pro.load(dbinfo.getInputStream());
//			setUser(pro.getProperty("user"));
//			log.info("user : {}", user);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try(
//				InputStream is = cpRes.getInputStream();
//		){
//			props.load(is);
//			log.info("주입된 리소스 : {}", cpRes);
//			log.info("주입된 리소스 : {}", fsRes);
//			log.info("dbinfo 리소스 : {}", dbinfo);
//			log.info("user 값 : {}", user);
//		}catch (IOException e) {
//			throw new UncheckedIOException(e);
//		}
	}
	
	private PersonVO rawToObject(String id , String rawData) {
		String[] tokens = rawData.split("\\|");
		return new PersonVO(id, tokens[0], tokens[1], tokens[2], tokens[3]);
		
	}
	
	@Override
	public List<PersonVO> selectPersonList(){
		List<PersonVO> people = new ArrayList<PersonVO>();
		Enumeration<Object> keys = props.keys();
		while (keys.hasMoreElements()) {
			Object key= (Object) keys.nextElement();
			Object value = props.get(key);
			PersonVO person = rawToObject(key.toString(), value.toString());
			people.add(person);
		}
		return people;
	}
	
	@Override
	public PersonVO selectPerson(String id){
		String property = props.getProperty(id);
//		if(property!=null) {
//			return rawToObject(id, property);
//		}else {
//			return null;
//		}
		return Optional.ofNullable(property).map((p)->rawToObject(id, p)).orElse(null);
	}
}
