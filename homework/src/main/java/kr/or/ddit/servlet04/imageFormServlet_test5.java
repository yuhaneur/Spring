package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
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
@WebServlet(urlPatterns="/test5/imageForm.do",asyncSupported =true)
public class imageFormServlet_test5 extends HttpServlet{
	private ServletContext application;
	
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
	    final AsyncContext asyncContext = req.startAsync();
	    ServletContext application = req.getServletContext(); // application 객체를 얻습니다.
	    new Thread(new Runnable() {
	        @Override
	        public void run() {
	            HttpServletResponse response = (HttpServletResponse) asyncContext.getResponse();
	            response.setContentType("text/html");
	            response.setCharacterEncoding("UTF-8");
	            File folder = new File("D:/00.medias/images"); 
	            try {
	                String[] fileList =folder.list(new FilenameFilter() {
	                    @Override
	                    public boolean accept(File dir, String name) {
	                        String mime = application.getMimeType(name); // application 객체를 활용합니다.
	                        return mime!=null && mime.startsWith("image/");
	                    }
	                });
	                StringBuilder options = new StringBuilder();
	                for(String name : fileList) {
	                	options.append("<option value='" + name + "'>" + name + "</option>");
	                }
	                response.getWriter().write(options.toString());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            asyncContext.complete();
	        }
	    }).start();
	}
	
	
}
