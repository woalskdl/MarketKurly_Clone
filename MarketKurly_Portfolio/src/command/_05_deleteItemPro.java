package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.managerDAO;

public class _05_deleteItemPro implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		System.out.println("delItem - item_number : " + item_number);
		managerDAO.getInstance().deleteItem(item_number);
		
		request.setAttribute("type", new Integer(0));
		
		return "/05_deleteItemPro.jsp";
	}
}
