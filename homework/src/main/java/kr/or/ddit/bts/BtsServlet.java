package kr.or.ddit.bts;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bts")
public class BtsServlet extends HttpServlet{
	private BtsService service;
	private ServletContext application;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = BtsService.getInstence();
		application = config.getServletContext();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map = service.btsList();
		System.out.println(map.size());
		application.setAttribute("btsMap", map);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/bts/btsView.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("type");
		boolean check;
		try {
			check = service.check(name);
			System.out.println("있냐 ?" +check);
			String path = String.format("/WEB-INF/views/bts/%s.jsp",name);
			req.setAttribute("path", path);
			req.getRequestDispatcher("/WEB-INF/views/bts/btsMember.jsp").forward(req, resp);
		}catch(RuntimeException e) {
			resp.sendError(400,e.getMessage());
		}
	}
}
