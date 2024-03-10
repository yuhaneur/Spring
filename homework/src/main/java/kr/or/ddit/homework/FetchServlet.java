package kr.or.ddit.homework;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fetchServlet.do")
public class FetchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 캘린더 데이터를 가져오는 로직
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        // 이후 로직 생략

        // 가져온 캘린더 데이터를 JSP로 전달
        request.setAttribute("year", year);
        request.setAttribute("month", month);
        // 이후 로직 생략

        request.getRequestDispatcher("/WEB-INF/views/04/calendar.jsp").forward(request, response);
    }

}
