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

@WebServlet(loadOnStartup = 1,value="/bts2")
public class BtsServlet extends HttpServlet{
	private BtsService service;
	private ServletContext application;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		service = BtsService.getInstence();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map = service.btsList();
//		application.setAttribute("btsMap", map);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/webapp/bts/btsView.jsp").forward(req, resp);
	}
}
