package kr.or.ddit.bts;

import java.util.Map;

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
	
	public boolean check(String name) {
		return dao.check(name);
	}
	
	public Map<String,String> btsList() {
		return dao.btsList();
	}
}
