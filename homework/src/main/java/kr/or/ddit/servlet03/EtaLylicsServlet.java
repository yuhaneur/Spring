package kr.or.ddit.servlet03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 사용자로부터 /eta 요청을 받고,
 * 컨텐츠 폴더에 있는 eta_utf8.txt 파일에 있는 가사를 컨텐트로 서비스.
 *
 */
@WebServlet("/eta")
public class EtaLylicsServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		File f = new File("D:/00.medias/ETA_UTF8.txt");
		String mime = getServletContext().getMimeType(f.getName());
		resp.setContentType(String.format("%s;charset=utf-8",mime));
		try(
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			OutputStream os = resp.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
				
		){
			int box = -1;
			while((box=bis.read())!=-1) {
				bos.write(box);
			}

			
		}
	}
}
