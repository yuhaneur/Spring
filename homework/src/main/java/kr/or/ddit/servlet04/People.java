package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/people.do")
public class People extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		System.out.println("멤버 정보 서블릿");
	    File f = new File(classLoader.getResource("kr/or/ddit/MemberData.properties").getFile());
		try(
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		){
			String userId = request.getParameter("who");
			String line = null;
			Map<String, String[]> memberInfo = new HashMap<String, String[]>();
			String[] member = {};
			while((line = br.readLine())!=null) {
				member = line.split("=");
				String Id = member[0];
				String[] info = member[1].split("\\|");
				memberInfo.put(Id, info);
			}
			String[] infos=memberInfo.get(userId);
			String name = infos[0];
			String gender = infos[1];
			String age = infos[2];
			String addr = infos[3];
			System.out.println(name);
			System.out.println(gender);
			System.out.println(age);
			System.out.println(addr);
			StringBuffer content = new StringBuffer();
				content.append("<tr>                         ");
		        content.append("    <th>NAME</th>            ");
		        content.append(String.format("    <td>%s</td>    ", name));
		        content.append("</tr>                        ");
		        content.append("<tr>                         ");
		        content.append("    <th>GENDER</th>          ");
		        content.append(String.format("    <td>%s</td>    ", gender));
		        content.append("</tr>                        ");
		        content.append("<tr>                         ");
		        content.append("    <th>AGE</th>             ");
		        content.append(String.format("    <td>%s</td>    ", age));
		        content.append("</tr>                        ");
		        content.append("<tr>                         ");
		        content.append("    <th>ADDRESS</th>         ");
		        content.append(String.format("    <td>%s</td>    ", addr));
		        content.append("</tr>                        ");
		        response.setContentType("text/html;charset=utf-8");
		        PrintWriter out = response.getWriter();
		        out.println(content);
		}
	}
}
