package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.boardDAO;

public class _09_delete implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("UTF-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		boardDAO.getInstance().deleteBoard(num);
		
		request.setAttribute("type", new Integer(1));
		
		return "/09_delete.jsp";
	}
}
