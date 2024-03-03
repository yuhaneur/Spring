package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * case1 : model1 + servlet spec
 * case2 : template 구조 활용
 * case3 : jsp 스펙 활용
 * case4 : servlet + jsp --> model2
 * case5 : 비동기 처리
 *
 */
@WebServlet("/case5/imageForm.do")
public class imageFormServlet_case5 extends HttpServlet{
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application=  getServletContext();	
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		File folder = new File("D:/00.medias/images"); 
		
		String[] fileList =folder.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				return mime!=null && mime.startsWith("image/");
			}
		});
		StringBuffer options = new StringBuffer("");
		String optptrn="\n<option>%s</option>";
		for(String name : fileList) {
			options.append(String.format(optptrn, name));
		}
		req.setAttribute("options", options);
		req.setAttribute("cPath", req.getContextPath());
		String viewName = "/WEB-INF/views/04/imageForm.jsp";
		req.getRequestDispatcher(viewName).forward(req, resp);

		
		
	}
}
