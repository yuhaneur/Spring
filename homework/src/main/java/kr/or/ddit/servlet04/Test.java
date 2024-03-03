package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) throws IOException, IOException {
		ClassLoader classLoader = Test.class.getClassLoader();
	    File f = new File(classLoader.getResource("kr/or/ddit/MemberData.properties").getFile());
		try(
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		){
			
			
			
			String line = null;
			List<String> idList = new ArrayList<String>();
			Map<String, String[]> member = new HashMap<String, String[]>();
			String[] id = {};
			String[] info = {};
			while((line = br.readLine())!=null) {
				System.out.println(line);
				id = (line.split("="));
				String iid = id[0];
				idList.add(id[0]);
				info = id[1].split("\\|");
				member.put(iid, info);
			}
			String[] memberInfo = member.get("C0013");
			System.out.println("이름 : " +memberInfo[0]);
			System.out.println("성별 : " +memberInfo[1]);
			System.out.println("나이 : " +memberInfo[2]);
			System.out.println("주소 : "+memberInfo[3]);
			for(String str : idList) {
				System.out.println("id : " + str);
				
			}
			
			
		}
	}
	
}
