package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.customerDAO;

public class _02_checkDoubleEmail implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String email = (String)request.getParameter("email");
		int check = customerDAO.getInstance().checkDoubleEmail(email);
		
		request.setAttribute("email", email);
		request.setAttribute("check", new Integer(check));
		request.setAttribute("type", new Integer(1));
		
		return "/02_checkDouble.jsp";
	}
}
