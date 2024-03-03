package kr.or.ddit.servlet04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/peopleList.do")
public class PeopleList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassLoader classLoader = Test.class.getClassLoader();
	    File f = new File(classLoader.getResource("kr/or/ddit/MemberData.properties").getFile());
		try(
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
		){
			
			String line = null;
			List<String[]> memberList = new ArrayList<String[]>();
			String[] a = {};
			while((line = br.readLine())!=null) {
				System.out.println(line);
				a = (line.split("="));
				String id = a[0];
			    String name = a[1].split("\\|")[0];
			    String[] idName = new String[]{id,name};
			    memberList.add(idName);
			}

			request.setAttribute("memberList", memberList);
			request.getRequestDispatcher("/WEB-INF/views/04/memberList.jsp").forward(request, response);
		}
	}

}
