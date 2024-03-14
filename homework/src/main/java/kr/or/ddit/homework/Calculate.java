package kr.or.ddit.homework;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calculate.do")
public class Calculate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String lo = req.getParameter("leftOp");
		String ro = req.getParameter("rightOp");
		String ot = req.getParameter("operator");
		if(ot==null||ot.isEmpty()) {
			resp.sendError(400,"연산자 선택하세요");
			return;
		}
		int leftOp=0;
		int rightOp=0;
		try {
			leftOp = Integer.parseInt(lo);
			rightOp = Integer.parseInt(ro);
		} catch (NumberFormatException e) {
			resp.sendError(400,"숫자를 넣어주세요");
		}
		String result = "";
		result = Sachick.findSachickName(ot);
		System.out.println("result : "+result);
		double res = 0;
		if(result.equals("+")) {
			res = Sachick.add(leftOp, rightOp);
		}else if(result.equals("-")) {
			res = Sachick.min(leftOp, rightOp);
		}else if(result.equals("*")) {
			res = Sachick.mul(leftOp, rightOp);
		}else if(result.equals("/")) {
			res = Sachick.div(leftOp, rightOp);
		}
		System.out.println("res : "+ res);
		req.setAttribute("res", res+"");
		req.setAttribute("leftOp", leftOp+"");
		req.setAttribute("rightOp", rightOp+"");
		System.out.println("result 저장하기전" + result);
		req.setAttribute("sachick", result+"");
		req.getRequestDispatcher("/homeworkk/result.jsp").forward(req, resp);
	}
}
