package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.customerDAO;

public class _01_loginPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		int check = customerDAO.getInstance().userCheck(id, pw);
		System.out.println("loginPro check = " + check);
		System.out.println("id = " + id);
		
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);
		request.setAttribute("type", new Integer(1));
		
		return "/01_loginPro.jsp";
	}
}
