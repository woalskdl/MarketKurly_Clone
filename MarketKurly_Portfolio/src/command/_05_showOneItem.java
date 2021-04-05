package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.itemDAO;
import bean.itemDTO;

public class _05_showOneItem implements CommandAction{
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		
		int item_num = Integer.parseInt(request.getParameter("item_num"));
		System.out.println("showOneItem item_num : " + item_num);
		ArrayList<itemDTO> dto = itemDAO.getInstance().getOneItem(item_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("type", new Integer(1));
		request.setAttribute("item_num", item_num);
		
		return "/05_showOneItem.jsp";
	}

}
