package kr.or.ddit.bts;

import java.util.Map;
import java.util.Optional;

public class BtsService {
	private BtsDao dao;
	
	private static BtsService service;
	private BtsService() {
		dao = BtsDao.getInstence();
	}
	public static BtsService getInstence() {
		if(service==null) service= new BtsService();
		return service;
	}
	
	public boolean check(String name) throws IllegalArgumentException{
		Optional.ofNullable(name)
		.filter(nm->!nm.isEmpty())
		.orElseThrow(()->new IllegalArgumentException("정확한 선택해주세요"));
		return dao.check(name);
	}
	
	public Map<String,String> btsList() {
		return dao.btsList();
	}
}
