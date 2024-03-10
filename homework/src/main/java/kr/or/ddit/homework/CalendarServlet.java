package kr.or.ddit.homework;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calendar.do")
public class CalendarServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Calendar cal = Calendar.getInstance();

		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DATE);
		System.out.println("year"+year);
		System.out.println("month"+month);
		System.out.println("day"+day);
		
		String ny = request.getParameter("year");
		String nm = request.getParameter("month");
		String pm = request.getParameter("pmonth");
		
		if(ny!=null) {
			year = Integer.parseInt(ny);
		}
		if(pm!=null) {
			month = Integer.parseInt(pm)-1;
			if(month<1) {
				month=12;
				year--;
			}
			System.out.println("파라미터 달 "+ month);
		}
		if(nm!=null) {
			month = Integer.parseInt(nm)+1;
			if(month>12) {
				month=1;
				year++;
			}
			System.out.println("파라미터 달 "+ month);
		}
		
		cal.set(year, month-1, 1);
		int lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH);
		System.out.println("lastDay"+lastDay);
		int week = cal.get(Calendar.DAY_OF_WEEK); 
		System.out.println("week"+week);
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("lastDay", lastDay);
		request.setAttribute("week", week);
		
		request.getRequestDispatcher("/WEB-INF/views/04/calendar.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
