package kr.or.ddit.bts;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class BtsDao {
	private static BtsDao dao;
	private BtsDao() {}
	public static BtsDao getInstence() {
		if(dao==null) dao= new BtsDao();
		return dao;
	}
	
	public boolean check(String name) {
		ResourceBundle bundle =  ResourceBundle.getBundle("kr.or.ddit.bts.Bts");
		Set<String> keySet = bundle.keySet();
		Iterator<String> it =  keySet.iterator();
		while (it.hasNext()) {
			String code = (String) it.next();
			String message = bundle.getString(code);
			System.out.printf("%s : %s\n",code,message);
		} 
		boolean result;
		result = keySet.contains(name);
		return result;
	}
	public Map<String,String> btsList() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		ResourceBundle bundle =  ResourceBundle.getBundle("kr.or.ddit.bts.Bts");
		Set<String> keySet = bundle.keySet();
		Iterator<String> it =  keySet.iterator();
		while (it.hasNext()) {
			String code = (String) it.next();
			String message = bundle.getString(code);
			map.put(code, message);
		} 

		return map;
	}
}
