package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.managerDAO;

public class _01_managerLoginPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		managerDAO dao = managerDAO.getInstance();
		
		int check = dao.checkManager(id, pw);
		
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);
		request.setAttribute("type", new Integer(0));
		
		return "/01_managerLoginPro.jsp";
	}
}
