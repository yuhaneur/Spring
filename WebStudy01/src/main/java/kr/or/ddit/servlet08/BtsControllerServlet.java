package kr.or.ddit.servlet08;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.exception.ResponseStatusException;

@WebServlet("/bts")
public class BtsControllerServlet extends HttpServlet{
	
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		Map<String, String[]> btsMap = new LinkedHashMap<String, String[]>();
		btsMap.put("B001", new String[] {"뷔","bts/bui"});
		btsMap.put("B002", new String[] {"제이홉","bts/jhop"});
		btsMap.put("B003", new String[] {"지민","bts/jimin"});
		btsMap.put("B004", new String[] {"진","bts/jin"});
		btsMap.put("B005", new String[] {"정국","bts/jungkuk"});
		btsMap.put("B006", new String[] {"RM","bts/rm"});
		btsMap.put("B007", new String[] {"슈가","bts/suga"});
		
		application.setAttribute("btsMap", btsMap);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String viewName = "/WEB-INF/views/bts/btsForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 디코딩
		 req.setCharacterEncoding("UTF-8");
		 Map<String, String[]> btsMap = (Map) application.getAttribute("btsMap");
		
		String member1 = req.getParameter("member");
		int status = 200;
		if(StringUtils.isBlank(member1)) {
			status = 400;
		}else if(!btsMap.containsKey(member1)) {
			status =404;
		}
		
		if(status ==200) {
			String[] btsData = btsMap.get(member1);
			String path = btsData[1];
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			
			req.setAttribute("content", prefix+path+suffix);
			req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
		}else {
			resp.sendError(status);
		}
		 
//		// 파라미터 누락시 에러 400
//		String member = Optional.ofNullable(req.getParameter("member"))
//					.filter(mb->!mb.isEmpty())
//					.orElseThrow(()->new ResponseStatusException(400, "선택해요"));
//		
//		// 멤버이름정확한지 검증
//		String a = null;
//		if(btsMap.containsKey(member)) {
//			for(Entry<String, String[]> entry : btsMap.entrySet()) {
//				if(member.equals(entry.getKey())) {
//					
//				String[] b = entry.getValue();
//				a = b[1]; 
//				System.out.println("a : "+ a);
//				}
//				
//			}
//		}
//		String content = String.format("/WEB-INF/views/%s.jsp", a);
//		req.setAttribute("content", content);
//		req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
	}
}
