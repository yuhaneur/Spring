package kr.or.ddit.btss.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.btss.service.BtsService;
import kr.or.ddit.btss.service.BtsServiceImpl;
import kr.or.ddit.exception.PkNotFoundException;
import kr.or.ddit.vo.BtsVO;

@WebServlet("/case2/bts")
public class BtsControllerServlet_case2 extends HttpServlet{
	private BtsService service = new BtsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<BtsVO> btsList = service.readBtsList();
		Comparator<BtsVO> countSort = new Comparator<BtsVO>() {
			@Override
			public int compare(BtsVO o1, BtsVO o2) {
				return o2.getCount() - o1.getCount(); 
			}
		};
		Collections.sort(btsList, countSort);
		req.setAttribute("BtsList", btsList);
		req.getRequestDispatcher("/WEB-INF/views/bts/btsForm_case2.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String member1 = req.getParameter("member");
		int status = 200;
		if(StringUtils.isBlank(member1)) {
			status = 400;
		}
		try {
			BtsVO bts = service.readBts(member1);
			String path = bts.getPath();
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			
			req.setAttribute("content", prefix+path+suffix);
			req.setAttribute("bts", bts);
			
		}catch(PkNotFoundException e) {
			status = e.getStatus();
		}
		if(status ==200) {
			req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
		}else {
			resp.sendError(status);
		}
		
		
//		String member = req.getParameter("member");
//		BtsVO vo =  service.readBts(member);
//		String path = vo.getPath();
//		
//		String content = String.format("/WEB-INF/views/%s.jsp", path);
//		req.setAttribute("content", content);
//		req.getRequestDispatcher("/WEB-INF/views/bts/base.jsp").forward(req, resp);
				
	}
}
