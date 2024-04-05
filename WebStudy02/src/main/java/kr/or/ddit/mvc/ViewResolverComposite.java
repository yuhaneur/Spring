package kr.or.ddit.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewResolverComposite implements ViewResolver {
	
	private List<ViewResolver> viewResolvers;
	{
		ViewResolver CNVR = new ContentNegotiatingViewResolver();
		ViewResolver TVR = new TilesViewResolver();
		ViewResolver IRVR = new InternalResourceViewResolver();
		IRVR.setPrefix("/WEB-INF/views/");
		IRVR.setSuffix(".jsp");
		viewResolvers = new ArrayList<>();
		// 항상 처음 (viewName을 안쓰기떄문에)
		viewResolvers.add(CNVR);
		viewResolvers.add(TVR);
		// 항상 가장 마지막에 동작해야함. ( exception 처리안했음)
		viewResolvers.add(IRVR);
	}
	
	@Override
	public void resolveView(String viewName, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (viewName.startsWith("redirect:")) {
			String location = viewName.replace("redirect:", req.getContextPath());
			resp.sendRedirect(location);
		}else if (viewName.startsWith("forward:")) {
			String path = viewName.substring("forward:".length());
			req.getRequestDispatcher(path).forward(req,resp);
		}else {
			for(ViewResolver single : viewResolvers) {
				try {
					single.resolveView(viewName, req, resp);
					log.info("{} 이 {} 을 해결했음 추카추카!!!!",single.getClass().getSimpleName(),viewName);
					break;
				}catch(CannotResolveViewNameException e) {
					log.warn("{} 이 {} 을 해결하지 못했으ㅠㅠㅠㅠㅠㅠ",single.getClass().getSimpleName(),viewName);
					continue;
				}
			}
		}

	}

}
