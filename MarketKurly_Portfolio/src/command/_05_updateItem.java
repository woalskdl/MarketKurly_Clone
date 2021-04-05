package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.itemDTO;
import bean.managerDAO;

public class _05_updateItem implements CommandAction{
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		
		int item_number = Integer.parseInt(request.getParameter("item_number"));
		
		System.out.println("updateItme - item_number : " + item_number);
		ArrayList<itemDTO> bean = managerDAO.getInstance().getOneItem(item_number);
		
		request.setAttribute("beanForUpdate", bean);
		request.setAttribute("type", new Integer(0));
		
		return "/05_updateItem.jsp";
	}
}
