package kr.or.ddit.servlet09;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serverFile")
public class ServerFileExplorer extends HttpServlet{
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application =  getServletContext();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String base =Optional.ofNullable(req.getParameter("base"))
							 .filter((bp)->!bp.isEmpty())
							 .orElse("/");
		
		Map<String,File> fileMap = new HashMap<String, File>();
		for(String path : application.getResourcePaths(base)) {
			String realPath = application.getRealPath(path);
			File tmp = new File(realPath);
			fileMap.put(path,tmp);
		}
		req.setAttribute("fileMap", fileMap);
		String viewName = "/WEB-INF/views/explorer/fileView.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);
	}
}
