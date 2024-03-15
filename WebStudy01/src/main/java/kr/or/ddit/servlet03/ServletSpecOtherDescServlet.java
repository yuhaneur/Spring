package kr.or.ddit.servlet03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


/**
 * 서블릿 스펙 제공 객체
 * 1. HttpServletRequest : http 프로토콜로 발생한 요청과 해당 요청을 발생시킨 클라이언트에 대한 정보를 가진 객체.
 * 							stateless(상태가없다) 객체(1:1로 응답이 전송된 후 제거되는 객체).
 * 2. HttpServletResponse : 응답으로 전송할 메인 컨텐츠와 해당 컨텐츠에 대한 메타데이터를 가진 객체.
 * 3. HttpSession : 한 클라이언트에 대해 독립적으로 운영되는 객체(서버의 저장구조로 유지되는 객체).
 * 4. ServletContext : 하나의 서버(WAS, Servlet container)와 현재 컨텍스트(WebStudy01)에 대한 정보를 가진 객체(싱글턴 객체).
 * 5. ServletConfig : 컨테이너에 등록된 서블릿과 1:1 관계로 생성되는 객체.
 * 					  해당 서블릿의 메타데이터를 가진 객체
 * 						ex) servletname, initParameter
 * 6. Cookie : 클라이언트의 저장구조를 통해 상태가 유지되는 객체.
 */
@WebServlet(value = "/nouse", loadOnStartup = 1)
public class ServletSpecOtherDescServlet extends HttpServlet{
	private ServletContext application;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application =  getServletContext();
		System.out.printf("contextPath : %s\n",application.getContextPath());
		System.out.printf("session tracking mode : %s\n",application.getDefaultSessionTrackingModes());
		System.out.printf("servlet spec version : %d.%d\n",application.getEffectiveMajorVersion(),application.getEffectiveMinorVersion());
		System.out.printf("Server info : %s\n",application.getServerInfo());
	}
}
