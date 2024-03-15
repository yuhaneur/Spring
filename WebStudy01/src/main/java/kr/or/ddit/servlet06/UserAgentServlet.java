package kr.or.ddit.servlet06;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.enumpkg.BrowserInfo;

@WebServlet("/07/userAgent.do")
public class UserAgentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String agent = req.getHeader("user-agent").toUpperCase();
		System.out.println(agent);
		String result= "기타";
		
//		Map<String, String> browserInfo = new LinkedHashMap<>();
//		browserInfo.put("EDG","엣지");
//		browserInfo.put("WHALE","웨일");
//		browserInfo.put("CHROME","크롬");
//		browserInfo.put("SAFARI","사파리");
//		browserInfo.put("other","기타");
//		
//		for(Entry<String, String> entry : browserInfo.entrySet()) {
//			if(agent.contains(entry.getKey())) {
//				result = entry.getValue();
//				break;
//			}
//		}
//		
//		BrowserInfo[] infos = BrowserInfo.values();
//		for(BrowserInfo single : infos) {
//			if(agent.contains(single.name())) {
//				result = single.getBrowserName();
//				break;
//			}
//		}
		
//		BrowserInfo finded = BrowserInfo.findBrowser(agent);
//		result = finded.getBrowserName();
		
		result=BrowserInfo.findBrowerName(agent);
//		if(agent.contains("EDG")) {
//			result = "엣지";
//		}else if(agent.contains("WHALE")) {
//			result = "웨일";
//		}else if(agent.contains("CHROME")) {
//			result = "크롬";
//		}else if(agent.contains("SAFARI")){
//			result = "사파리";
//		}else {
//			result ="기타";
//		}
		String message = String.format("당신의 브라우저는 %s 입니다.", result);
		resp.setCharacterEncoding("utf-8");
		try(
		PrintWriter out = resp.getWriter();
		){
			out.print(message);	
		}
		
	}
}
