package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageForm.do")
public class ImageForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String image = request.getParameter("image");
		File imageFolder = new File("D:/00.medias/images");
		File imageFile = new File(imageFolder, image);
		if(image==null || image.isEmpty()) {
			String[] fileName = imageFolder.list();
			System.out.println(fileName);
			request.setAttribute("fileName", fileName);
			
			request.getRequestDispatcher("/03/homework.jsp").forward(request, resp);
		}
		
		if(!imageFile.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,String.format("%s 파일은 없음.", image) );
			return;
		}
		
		resp.setContentLengthLong(imageFile.length());
		try(
			InputStream is = new FileInputStream(imageFile);
			BufferedInputStream bis = new BufferedInputStream(is);
			
			OutputStream os = resp.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			){
			
			int length = -1;
			while((length = bis.read())!=-1) {	// EOF 문자 : -1, null
				bos.write(length);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}{
			
		}
	}


}
