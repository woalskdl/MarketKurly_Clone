package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.itemDAO;
import bean.itemDTO;

public class _04_showNewItem implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		ArrayList<itemDTO> itemList = itemDAO.getInstance().getNewItem();
		
		request.setAttribute("itemList", itemList);
		request.setAttribute("type", new Integer(1));
		
		return "/04_showItems.jsp";
	}
}
