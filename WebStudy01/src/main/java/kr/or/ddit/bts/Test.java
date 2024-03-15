package kr.or.ddit.bts;

import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		ResourceBundle bundle =  ResourceBundle.getBundle("kr.or.ddit.bts.Bts");
		Set<String> keySet = bundle.keySet();
		Iterator<String> it =  keySet.iterator();
		while (it.hasNext()) {
			String code = (String) it.next();
			String message = bundle.getString(code);
			System.out.printf("%s : %s\n",code,message);
		}
		
		String name = "bui";
		System.out.println(keySet.contains(name));
	}
}
