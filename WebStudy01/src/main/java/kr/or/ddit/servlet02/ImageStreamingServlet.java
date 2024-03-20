package kr.or.ddit.servlet02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/image.do")
public class ImageStreamingServlet extends HttpServlet{
	private ServletContext application;
	private String imageFolderPath;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
		System.out.println(application);
		imageFolderPath = application.getInitParameter("imageFolder");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		if((name==null ||name.isEmpty()) || name.equals("")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"이미지 파일 명이 없음.");
			return;
		}
		
		File imageFolder = new File(imageFolderPath);
		File imageFile = new File(imageFolder, name);
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,String.format("%s 파일은 없음.", name) );
			return;
		}
		

		
		
		
		
		String mime = application.getMimeType(imageFile.getName());
		System.out.println(mime);
		if(mime==null || !mime.startsWith("image")) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"정상적인 이미지 파일이 아님");
			return;
		}
		System.out.println("name : " + name);
		
		Cookie cookie = new Cookie("imageFile", URLEncoder.encode(name,"UTF-8"));
		cookie.setPath(req.getContextPath());
		cookie.setMaxAge(80000);
		resp.addCookie(cookie);
		
		resp.setContentType(mime);
		resp.setContentLengthLong(imageFile.length());
		try(
			InputStream is = new FileInputStream(imageFile);
			OutputStream os = resp.getOutputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			){
			
		// stream copy
//		byte[] buffer = new byte[1024];
			int length = -1;
			while((length = bis.read())!=-1) {	// EOF 문자 : -1, null
				bos.write(length);
			}
		}
		
	}
}
